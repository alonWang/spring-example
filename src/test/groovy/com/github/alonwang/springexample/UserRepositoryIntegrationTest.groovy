package com.github.alonwang.springexample

import com.github.alonwang.springexample.model.User
import com.github.alonwang.springexample.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.Example
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith
import static org.springframework.data.domain.ExampleMatcher.StringMatcher
import static org.springframework.data.domain.ExampleMatcher.matching


/**
 * copy of https://github.com/spring-projects/spring-data-examples/blob/master/jpa/query-by-example/src/test/java/example/springdata/jpa/querybyexample/UserRepositoryIntegrationTests.java
 *
 * @author weilong.wang Created on 2018/9/5
 */
@SpringBootTest
@Transactional()
class UserRepositoryIntegrationTest extends Specification {
    @Autowired
    private UserRepository repository
    User skyler, walter, flynn, marie, hank

    def setup() {
        //repository.deleteAll()

        this.skyler = repository.save(new User("Skyler", "White", 45))
        this.walter = repository.save(new User("Walter", "White", 50))
        this.flynn = repository.save(new User("Walter Jr. (Flynn)", "White", 17))
        this.marie = repository.save(new User("Marie", "Schrader", 38))
        this.hank = repository.save(new User("Hank", "Schrader", 43))
    }

    def "count by test"() {
        when: "query lastname"
        def example = Example.of(new User(null, "White", null))
        then: "expect 3 match"
        repository.count(example) == 3
    }

    def "ignore properties and match by age"() {
        when: "generate example"
        def example = Example.of(flynn, matching().withIgnorePaths("firstname", "lastname"))
        then: "find this"
        repository.findOne(example).isPresent()
    }

    def "substring match"() {
        when: "generate a string ending matcher"
        def example = Example.of(new User("er", null, null),
                matching().withStringMatcher(StringMatcher.ENDING))
        then: "match"
        repository.findAll(example).containsAll(Arrays.asList(skyler, walter))
    }

    def "match starting string ignore case"() {
        when: "match start and ignore case"
        def example = Example.of(new User("Walter", "WHITE", null), matching()
                .withIgnorePaths("age").
                withMatcher("firstname", startsWith())
                .withMatcher("lastname", ignoreCase()))
        then: "find it"
        repository.findAll(example).containsAll(flynn, walter)
    }


}