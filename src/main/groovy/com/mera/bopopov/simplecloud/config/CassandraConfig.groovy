package com.mera.bopopov.simplecloud.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories(
        basePackages = "com.mera.bopopov.simplecloud.repository")
class CassandraConfig extends AbstractCassandraConfiguration {

    @Value('${cassandra.keyspace}')
    final String KEYSPACE

    @Value('${cassandra.endpoint}')
    final String ENPOINT

    @Value('${cassandra.port}')
    final Integer PORT

    @Override
    protected String getKeyspaceName() {
        return KEYSPACE
    }

    @Bean
    CassandraClusterFactoryBean cassandraClusterFactoryBean() {
        CassandraClusterFactoryBean cassandraClusterFactoryBean =
                new CassandraClusterFactoryBean()
        cassandraClusterFactoryBean.setContactPoints(ENPOINT)
        cassandraClusterFactoryBean.setPort(PORT)
        return cassandraClusterFactoryBean
    }

    @Bean
    CassandraMappingContext cassandraMappingContext() {
        return new CassandraMappingContext()
    }

}
