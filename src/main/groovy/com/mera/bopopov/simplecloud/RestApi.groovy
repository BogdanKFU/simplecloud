package com.mera.bopopov.simplecloud

import com.mera.bopopov.simplecloud.model.Message
import org.apache.camel.CamelContext
import org.apache.camel.Exchange
import org.apache.camel.Processor
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.impl.DefaultCamelContext
import org.apache.camel.model.rest.RestBindingMode
import org.apache.camel.model.rest.RestParamType
import org.springframework.stereotype.Component

@Component
class RestApi extends RouteBuilder {

    String contextPath

    @Override
    void configure() throws Exception {
        CamelContext context = new DefaultCamelContext()
        restConfiguration()
                .contextPath(contextPath)
                .port(8080)
                .enableCORS(true)
                .apiContextPath("/api-docs")
                .apiProperty("api.title", "Test REST API")
                .apiProperty("api.version", "v1")
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json)
        rest("/api/")
                .id("/api-route")
                .consumes("application/json")
                .get("/bean")
                .param()
                .name("id").type(RestParamType.query)
                .description("Message id").endParam()
                .param()
                .name("name").type(RestParamType.query)
                .description("Message name").endParam()
                .bindingMode(RestBindingMode.json)
                .type(Message)
                .to("direct:remoteService")
        from("direct:remoteService")
                .routeId("direct-route")
                .tracing()
                .log('>>> ${header.id}')
                .log('>>> ${header.name}')
                .process(new Processor() {
                    @Override
                    void process(Exchange exchange) throws Exception {
                        // There could be any processing such as saving to the database,
                        // logging, calculating some features
                        println "Completely kaput!"
                    }
                })
                .transform().simple('Hello ${header.name}')
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))

    }
}
