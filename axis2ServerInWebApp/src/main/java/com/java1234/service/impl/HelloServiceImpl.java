package com.java1234.service.impl;

import com.java1234.service.HelloService;

/**
 * @author gaoxu
 * @date 2019-07-04 13:12
 * @description ... 类
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {
        System.out.println("hello");
        return "hello";
    }

    @Override
    public String sayHelloToPerson(String name) {
        if (name == null || name.trim().equals("")) {
            name = "nobody";
        }
        System.out.println("hello" + name);
        return "hello," + name;
    }

}
