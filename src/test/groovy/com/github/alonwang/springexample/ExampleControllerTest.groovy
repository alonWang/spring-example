package com.github.alonwang.springexample

import com.github.alonwang.springexample.controller.ExampleController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Shared
import spock.lang.Specification

/**
 *
 *
 * @author weilong.wang Created on 2018/9/5
 */
@SpringBootTest
class ExampleControllerTest extends Specification {
    @Autowired
    private ExampleController exampleController
    @Shared
    private MockMvc mockMvc

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(exampleController).build()
    }

    def "example http request test"() {
        when: 'url hits'
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/example/one")).andReturn().response
        then:
        response.status == HttpStatus.OK.value()
        response.contentAsString == "true"
    }
}
