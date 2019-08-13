/**
 * HelloService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.java1234.webservice.client;

public interface HelloService extends javax.xml.rpc.Service {
    public String getHelloServiceHttpSoap12EndpointAddress();

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException;

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
    public String getHelloServiceHttpSoap11EndpointAddress();

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException;

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
