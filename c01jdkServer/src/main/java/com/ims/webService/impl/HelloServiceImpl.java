package com.ims.webService.impl;

import com.ims.webService.HelloService;

import javax.jws.WebService;


@WebService
public class HelloServiceImpl implements HelloService {

	public String say(String str) {
		return "Hello"+str;
	}

}
