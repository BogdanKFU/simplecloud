package com.mera.bopopov.simplecloud.repository

import com.mera.bopopov.simplecloud.model.CloudFile
import org.springframework.data.jpa.repository.JpaRepository

interface CloudFileRepository extends JpaRepository<CloudFile, UUID> {

}