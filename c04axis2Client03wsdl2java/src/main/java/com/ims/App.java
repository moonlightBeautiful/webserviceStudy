package com.ims;

import com.ims.webService.client.HelloServiceStub;

import java.rmi.RemoteException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws RemoteException {
        /*
         * 无参
         */
        /*HelloServiceStub stub = new HelloServiceStub();
        HelloServiceStub.SayHello sayHello = new HelloServiceStub.SayHello();
        HelloServiceStub.SayHelloResponse resp = stub.sayHello(sayHello);
        String ret = resp.get_return();
        System.out.println(ret);*/
        /*
         * 有参
         */
        HelloServiceStub stub = new HelloServiceStub();
        HelloServiceStub.SayHelloToPerson sayHelloToPerson = new HelloServiceStub.SayHelloToPerson();
        //入参
        sayHelloToPerson.setName("高旭");
        HelloServiceStub.SayHelloToPersonResponse resp = stub.sayHelloToPerson(sayHelloToPerson);
        String ret = resp.get_return();
        System.out.println(ret);


    }
}
