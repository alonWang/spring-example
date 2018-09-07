package com.github.alonwang.springexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author weilong.wang Created on 2018/9/5
 */
@Entity
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
public class User {
	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;
	private String firstname, lastname;
	private Integer age;

	public User(String firstname, String lastname, Integer age) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}
}
