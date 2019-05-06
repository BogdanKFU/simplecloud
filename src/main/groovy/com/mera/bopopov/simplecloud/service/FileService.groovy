package com.mera.bopopov.simplecloud.service

import com.mera.bopopov.simplecloud.model.User

interface FileService {

    void add(File file)

    void delete(File file)

    List<File> getAll(User user)

}