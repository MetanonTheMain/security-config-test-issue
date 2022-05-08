package com.example.securityconfigtestissue.controller

import com.example.securityconfigtestissue.model.SomeEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {
    @PostMapping("/somePostReq")
    fun somePostReq(@RequestBody someEntity: SomeEntity): ResponseEntity<Unit> {
        return ResponseEntity.ok().build()
    }
}