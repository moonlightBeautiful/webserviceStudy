package com.ims.service.impl;


import com.ims.service.HelloWorldService;

/**
 * @author: GaoXu
 * @date: 2020/5/24
 * @desc��������������
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String sayHiToUser(String str) {
        System.out.println("��ã�" + str);
        return str;
    }

}
