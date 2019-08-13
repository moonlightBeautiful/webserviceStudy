/**
 * HelloServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.java1234.webservice.client;

public class HelloServiceLocator extends org.apache.axis.client.Service implements HelloService {

    public HelloServiceLocator() {
    }


    public HelloServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloServiceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloServiceHttpSoap12Endpoint
    private String HelloServiceHttpSoap12Endpoint_address = "http://localhost:8080/services/HelloService.HelloServiceHttpSoap12Endpoint/";

    public String getHelloServiceHttpSoap12EndpointAddress() {
        return HelloServiceHttpSoap12Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String HelloServiceHttpSoap12EndpointWSDDServiceName = "HelloServiceHttpSoap12Endpoint";

    public String getHelloServiceHttpSoap12EndpointWSDDServiceName() {
        return HelloServiceHttpSoap12EndpointWSDDServiceName;
    }

    public void setHelloServiceHttpSoap12EndpointWSDDServiceName(String name) {
        HelloServiceHttpSoap12EndpointWSDDServiceName = name;
    }

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap12Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloServiceHttpSoap12Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloServiceHttpSoap12Endpoint(endpoint);
    }

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap12Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.java1234.webservice.client.HelloServiceSoap12BindingStub _stub = new com.java1234.webservice.client.HelloServiceSoap12BindingStub(portAddress, this);
            _stub.setPortName(getHelloServiceHttpSoap12EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloServiceHttpSoap12EndpointEndpointAddress(String address) {
        HelloServiceHttpSoap12Endpoint_address = address;
    }


    // Use to get a proxy class for HelloServiceHttpSoap11Endpoint
    private String HelloServiceHttpSoap11Endpoint_address = "http://localhost:8080/services/HelloService.HelloServiceHttpSoap11Endpoint/";

    public String getHelloServiceHttpSoap11EndpointAddress() {
        return HelloServiceHttpSoap11Endpoint_address;
    }

    // The WSDD service name defaults to the port name.
    private String HelloServiceHttpSoap11EndpointWSDDServiceName = "HelloServiceHttpSoap11Endpoint";

    public String getHelloServiceHttpSoap11EndpointWSDDServiceName() {
        return HelloServiceHttpSoap11EndpointWSDDServiceName;
    }

    public void setHelloServiceHttpSoap11EndpointWSDDServiceName(String name) {
        HelloServiceHttpSoap11EndpointWSDDServiceName = name;
    }

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap11Endpoint() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloServiceHttpSoap11Endpoint_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloServiceHttpSoap11Endpoint(endpoint);
    }

    public com.java1234.webservice.client.HelloServicePortType getHelloServiceHttpSoap11Endpoint(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.java1234.webservice.client.HelloServiceSoap11BindingStub _stub = new com.java1234.webservice.client.HelloServiceSoap11BindingStub(portAddress, this);
            _stub.setPortName(getHelloServiceHttpSoap11EndpointWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloServiceHttpSoap11EndpointEndpointAddress(String address) {
        HelloServiceHttpSoap11Endpoint_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     * This service has multiple ports for a given interface;
     * the proxy implementation returned may be indeterminate.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.java1234.webservice.client.HelloServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.java1234.webservice.client.HelloServiceSoap12BindingStub _stub = new com.java1234.webservice.client.HelloServiceSoap12BindingStub(new java.net.URL(HelloServiceHttpSoap12Endpoint_address), this);
                _stub.setPortName(getHelloServiceHttpSoap12EndpointWSDDServiceName());
                return _stub;
            }
            if (com.java1234.webservice.client.HelloServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.java1234.webservice.client.HelloServiceSoap11BindingStub _stub = new com.java1234.webservice.client.HelloServiceSoap11BindingStub(new java.net.URL(HelloServiceHttpSoap11Endpoint_address), this);
                _stub.setPortName(getHelloServiceHttpSoap11EndpointWSDDServiceName());
                return _stub;
            }
        }
        catch (Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        String inputPortName = portName.getLocalPart();
        if ("HelloServiceHttpSoap12Endpoint".equals(inputPortName)) {
            return getHelloServiceHttpSoap12Endpoint();
        }
        else if ("HelloServiceHttpSoap11Endpoint".equals(inputPortName)) {
            return getHelloServiceHttpSoap11Endpoint();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.service.java1234.com", "HelloService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.service.java1234.com", "HelloServiceHttpSoap12Endpoint"));
            ports.add(new javax.xml.namespace.QName("http://impl.service.java1234.com", "HelloServiceHttpSoap11Endpoint"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloServiceHttpSoap12Endpoint".equals(portName)) {
            setHelloServiceHttpSoap12EndpointEndpointAddress(address);
        }
        else 
if ("HelloServiceHttpSoap11Endpoint".equals(portName)) {
            setHelloServiceHttpSoap11EndpointEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
