package com.mera.bopopov.simplecloud

import org.apache.camel.CamelAuthorizationException
import org.apache.camel.component.servlet.CamelHttpTransportServlet
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean

@SpringBootApplication
class Server {

    @Value('${simplecloud.api.path}')
    String contextPath

    @Bean
    ServletRegistrationBean servletCamelRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(
                new CamelHttpTransportServlet(), contextPath + "/*"
        )
        servlet.name = "CamelServlet"
        servlet
    }

    static void main(String [] args) {
        // https://www.baeldung.com/apache-camel-spring-boot
        SpringApplication app = new SpringApplication(Server.class)
        app.run(args)
    }

}
