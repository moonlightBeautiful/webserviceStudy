/**
 * AVMPMInterfaceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.java1234.webservice.clientNet02Erp;

public class AVMPMInterfaceLocator extends org.apache.axis.client.Service implements com.java1234.webservice.clientNet02Erp.AVMPMInterface {

    public AVMPMInterfaceLocator() {
    }


    public AVMPMInterfaceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AVMPMInterfaceLocator(String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AVMPMInterfaceSoap12
    private String AVMPMInterfaceSoap12_address = "http://10.128.3.120/cwbase/gsp/webservice/ampm/AVMPMInterface.asmx";

    public String getAVMPMInterfaceSoap12Address() {
        return AVMPMInterfaceSoap12_address;
    }

    // The WSDD service name defaults to the port name.
    private String AVMPMInterfaceSoap12WSDDServiceName = "AVMPMInterfaceSoap12";

    public String getAVMPMInterfaceSoap12WSDDServiceName() {
        return AVMPMInterfaceSoap12WSDDServiceName;
    }

    public void setAVMPMInterfaceSoap12WSDDServiceName(String name) {
        AVMPMInterfaceSoap12WSDDServiceName = name;
    }

    public com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_PortType getAVMPMInterfaceSoap12() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AVMPMInterfaceSoap12_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAVMPMInterfaceSoap12(endpoint);
    }

    public com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_PortType getAVMPMInterfaceSoap12(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap12Stub _stub = new com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap12Stub(portAddress, this);
            _stub.setPortName(getAVMPMInterfaceSoap12WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAVMPMInterfaceSoap12EndpointAddress(String address) {
        AVMPMInterfaceSoap12_address = address;
    }


    // Use to get a proxy class for AVMPMInterfaceSoap
    private String AVMPMInterfaceSoap_address = "http://10.128.3.120/cwbase/gsp/webservice/ampm/AVMPMInterface.asmx";

    public String getAVMPMInterfaceSoapAddress() {
        return AVMPMInterfaceSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private String AVMPMInterfaceSoapWSDDServiceName = "AVMPMInterfaceSoap";

    public String getAVMPMInterfaceSoapWSDDServiceName() {
        return AVMPMInterfaceSoapWSDDServiceName;
    }

    public void setAVMPMInterfaceSoapWSDDServiceName(String name) {
        AVMPMInterfaceSoapWSDDServiceName = name;
    }

    public com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_PortType getAVMPMInterfaceSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AVMPMInterfaceSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAVMPMInterfaceSoap(endpoint);
    }

    public com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_PortType getAVMPMInterfaceSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_BindingStub _stub = new com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_BindingStub(portAddress, this);
            _stub.setPortName(getAVMPMInterfaceSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAVMPMInterfaceSoapEndpointAddress(String address) {
        AVMPMInterfaceSoap_address = address;
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
            if (com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap12Stub _stub = new com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap12Stub(new java.net.URL(AVMPMInterfaceSoap12_address), this);
                _stub.setPortName(getAVMPMInterfaceSoap12WSDDServiceName());
                return _stub;
            }
            if (com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_BindingStub _stub = new com.java1234.webservice.clientNet02Erp.AVMPMInterfaceSoap_BindingStub(new java.net.URL(AVMPMInterfaceSoap_address), this);
                _stub.setPortName(getAVMPMInterfaceSoapWSDDServiceName());
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
        if ("AVMPMInterfaceSoap12".equals(inputPortName)) {
            return getAVMPMInterfaceSoap12();
        }
        else if ("AVMPMInterfaceSoap".equals(inputPortName)) {
            return getAVMPMInterfaceSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "AVMPMInterface");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "AVMPMInterfaceSoap12"));
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "AVMPMInterfaceSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(String portName, String address) throws javax.xml.rpc.ServiceException {
        
if ("AVMPMInterfaceSoap12".equals(portName)) {
            setAVMPMInterfaceSoap12EndpointAddress(address);
        }
        else 
if ("AVMPMInterfaceSoap".equals(portName)) {
            setAVMPMInterfaceSoapEndpointAddress(address);
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
