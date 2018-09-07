package com.github.alonwang.springexample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.github.alonwang.springexample.model.User;

/**
 * @author weilong.wang Created on 2018/9/5
 */
public interface UserRepository
		extends CrudRepository<User, Long>, QueryByExampleExecutor<User> {
}
