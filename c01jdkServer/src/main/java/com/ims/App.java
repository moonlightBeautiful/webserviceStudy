package com.ims;

import com.ims.webService.HelloService;
import com.ims.webService.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("web webService start");

        HelloService helloService = new HelloServiceImpl();
        String address = "http://192.168.1.33/service/helloService";
        Endpoint.publish(address, helloService); // jdk实现 暴露webservice接口

        System.out.println("web webService started");
    }
}
