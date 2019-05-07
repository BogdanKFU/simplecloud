package com.mera.bopopov.simplecloud.repository

import com.mera.bopopov.simplecloud.model.CloudFile
import org.springframework.data.cassandra.repository.CassandraRepository

interface CloudFileRepository extends CassandraRepository<CloudFile, UUID> {

}