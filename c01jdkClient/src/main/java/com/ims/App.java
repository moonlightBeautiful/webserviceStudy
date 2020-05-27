package com.ims;

import com.ims.webService.HelloServiceImpl;
import com.ims.webService.HelloServiceImplService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        HelloServiceImplService helloServiceImplService = new HelloServiceImplService();
        HelloServiceImpl helloService = helloServiceImplService.getHelloServiceImplPort();
        System.out.println(helloService.say("大爷"));
    }
}
