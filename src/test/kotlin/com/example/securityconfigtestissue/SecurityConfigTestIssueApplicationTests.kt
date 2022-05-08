package com.example.securityconfigtestissue


import com.example.securityconfigtestissue.config.SecurityConfigForTest
import com.example.securityconfigtestissue.model.SomeEntity
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.exchange
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ContextConfiguration
import org.springframework.web.util.UriComponentsBuilder

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [SecurityConfigTestIssueApplication::class, SecurityConfigForTest::class])
class SecurityConfigTestIssueApplicationTests {

    companion object {
        val PATH = "/somePostReq"
    }

    @Autowired
    protected lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun checkMyController() {
        val exchange: ResponseEntity<Unit> = testRestTemplate.exchange(
            UriComponentsBuilder
                .fromPath(PATH)
                .build().toString(),
            HttpMethod.POST, HttpEntity(SomeEntity("something")), Unit::class
        )

        assertEquals(exchange.statusCode, HttpStatus.OK)
    }

}
