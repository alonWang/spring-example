package com.github.alonwang.springexample.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author weilong.wang Created on 2018/9/5
 */
@Api("example")
@RestController
@RequestMapping("example")
public class ExampleController {
	@ApiOperation("swagger example api")
	@GetMapping("/one")
	public Boolean one() {
		return true;
	}
}
