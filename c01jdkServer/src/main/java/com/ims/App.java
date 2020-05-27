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
        String address = "http://192.168.1.3/service/helloService";
        // jdk实现 暴露webservice接口
        Endpoint.publish(address, helloService);

        System.out.println("web webService started");
    }
}
