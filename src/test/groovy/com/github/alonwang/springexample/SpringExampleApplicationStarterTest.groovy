package com.github.alonwang.springexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification


/**
 *
 *
 * @author weilong.wang Created on 2018/9/4
 */
@SpringBootTest(classes = SpringExampleApplication.class)
class SpringExampleApplicationStarterTest extends Specification {
    @Autowired
    private ApplicationContext applicationContext

    def "context load"() {
        expect: "load success"
        applicationContext != null
    }

}