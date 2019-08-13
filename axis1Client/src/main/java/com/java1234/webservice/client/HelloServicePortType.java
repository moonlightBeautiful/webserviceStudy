/**
 * HelloServicePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.java1234.webservice.client;

public interface HelloServicePortType extends java.rmi.Remote {
    public String sayHello() throws java.rmi.RemoteException;
    public String sayHelloToPerson(String name) throws java.rmi.RemoteException;
}
