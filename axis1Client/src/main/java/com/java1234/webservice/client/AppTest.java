package com.java1234.webservice.client;

import com.java1234.webservice.client.HelloServiceLocator;
import com.java1234.webservice.client.HelloServiceSoap12BindingStub;
import org.apache.axis.AxisFault;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 */
public class AppTest {
    public static void main(String[] args) throws MalformedURLException, AxisFault {
        HelloServiceLocator locator = new HelloServiceLocator();
        //***Soap11BindingStub和***Soap12BindingStub 一样使用
        HelloServiceSoap12BindingStub stub =
                new HelloServiceSoap12BindingStub(new URL(locator.getHelloServiceHttpSoap12EndpointAddress()), new
                        org.apache.axis.client.Service());
       /* HelloServiceSoap11BindingStub stub =
                new HelloServiceSoap11BindingStub(new URL(locator.getHelloServiceHttpSoap12EndpointAddress()), new
                        org.apache.axis.client.Service());*/

        /*stub.setTimeout(1000 * 40);*/
        /*System.out.println(stub.sayHello());*/
        try {
            System.out.println("开始时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            System.out.println(stub.sayHelloToPerson("高旭"));
            System.out.println("结束时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (RemoteException e) {
            System.out.println("结束时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            e.printStackTrace();
        }

       /*  String endpoint="http://ip/project/services/xxx?wsdl";

        Service service =new Service();

        org.apache.axis.client.Call call=(org.apache.axis.client.Call) service.createCall();

        call.setTargetEndpointAddress(endpoint);

        call.setOperationName("methodname");

        call.setTimeout(10000);  //单位是毫秒

        String ret =(String)call.invoke(new Object[] {xmldoc});*/
    }
}
