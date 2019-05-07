package com.mera.bopopov.simplecloud.model

import org.springframework.data.cassandra.core.cql.Ordering
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn

import javax.persistence.Table

@Table
class CloudFile {

    @PrimaryKeyColumn(
            name = "id",
            ordinal = 2,
            type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING
    )
    UUID id

    @PrimaryKeyColumn(
            name = "name",
            ordinal = 0,
            type = PrimaryKeyType.PARTITIONED
    )
    String name

    File file

}
