package com.ims.service.impl;

import com.ims.service.HelloService;

import java.text.SimpleDateFormat;
import java.util.Date;

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
        System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        if (name == null || name.trim().equals("")) {
            name = "nobody";
        }
       /* try {
            Thread.sleep(1000 * 60 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("hello" + name);
        return "hello," + name;
    }

}
