package com.java1234;

import com.java1234.webservice.client.HelloServiceLocator;
import com.java1234.webservice.client.HelloServiceSoap11BindingStub;

import java.net.URL;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        HelloServiceLocator locator = new HelloServiceLocator();
        //HelloServiceSoap11BindingStub和HelloServiceSoap12BindingStub 一样使用
        /*HelloServiceSoap12BindingStub stub =
                new HelloServiceSoap12BindingStub(new URL(locator.getHelloServiceHttpSoap11EndpointAddress()), new
                        org.apache.axis.client.Service());*/
        HelloServiceSoap11BindingStub stub =
                new HelloServiceSoap11BindingStub(new URL(locator.getHelloServiceHttpSoap12EndpointAddress()), new
                org.apache.axis.client.Service());
        System.out.println(stub.sayHello());
        System.out.println(stub.sayHelloToPerson("lizhuguan"));

    }
}
