package com.mera.bopopov.simplecloud.repository

import com.mera.bopopov.simplecloud.model.User
import org.springframework.data.cassandra.repository.CassandraRepository

interface UserRepository extends CassandraRepository<User, UUID> {

}