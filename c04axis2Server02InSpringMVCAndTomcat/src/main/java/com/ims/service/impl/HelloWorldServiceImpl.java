package com.ims.service.impl;


import com.ims.service.HelloWorldService;

/**
 * @author: GaoXu
 * @date: 2020/5/24
 * @desc：请对类进行描述
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHiToUser(String str) {
        System.out.println("你好：" + str);
        return str;
    }

}
