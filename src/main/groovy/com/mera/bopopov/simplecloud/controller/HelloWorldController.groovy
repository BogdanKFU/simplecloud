package com.mera.bopopov.simplecloud.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/files")
@RestController
class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    String findAll() {
        /*
        Get list of files
         */
        "Hello, world!"
    }

}
