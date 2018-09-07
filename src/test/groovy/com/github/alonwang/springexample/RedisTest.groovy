package com.github.alonwang.springexample


import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.ValueOperations
import spock.lang.Specification

import javax.annotation.Resource

/**
 *
 *
 * @author weilong.wang Created on 2018/9/6
 */
@SpringBootTest
class RedisTest extends Specification {
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> valueOperations


    def "redis connect test"() {
        when: "init redis value"
        valueOperations.set("abc", "1")
        def result = valueOperations.get("abc")
        then: "equal"
        result == "1"
    }
}