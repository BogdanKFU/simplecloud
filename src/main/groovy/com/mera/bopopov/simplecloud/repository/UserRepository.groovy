package com.mera.bopopov.simplecloud.repository

import com.mera.bopopov.simplecloud.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository extends JpaRepository<User, UUID> {

}