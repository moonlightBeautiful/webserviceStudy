package com.java1234;

import com.java1234.webservice.client.HelloServiceLocator;
import com.java1234.webservice.client.HelloServiceSoap11BindingStub;
import org.apache.axis.AxisFault;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws MalformedURLException, AxisFault {
        HelloServiceLocator locator = new HelloServiceLocator();
        //HelloServiceSoap11BindingStub和HelloServiceSoap12BindingStub 一样使用
        /*HelloServiceSoap12BindingStub stub =
                new HelloServiceSoap12BindingStub(new URL(locator.getHelloServiceHttpSoap11EndpointAddress()), new
                        org.apache.axis.client.Service());*/
        HelloServiceSoap11BindingStub stub =
                new HelloServiceSoap11BindingStub(new URL(locator.getHelloServiceHttpSoap12EndpointAddress()), new
                        org.apache.axis.client.Service());

        stub.setTimeout(60000);
        /*System.out.println(stub.sayHello());*/
        try {
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
            System.out.println(stub.sayHelloToPerson("高旭"));
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date()));
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
