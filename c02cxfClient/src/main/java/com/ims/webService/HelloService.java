package com.ims.webService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2020-04-03T21:55:44.083+08:00
 * Generated source version: 3.1.5
 * 
 */
@WebService(targetNamespace = "http://webService.ims.com/", name = "HelloService")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloService {

    @WebMethod
    @RequestWrapper(localName = "say", targetNamespace = "http://webService.ims.com/", className = "com.ims.webService.Say")
    @ResponseWrapper(localName = "sayResponse", targetNamespace = "http://webService.ims.com/", className = "com.ims.webService.SayResponse")
    @WebResult(name = "return", targetNamespace = "")
    public String say(
            @WebParam(name = "arg0", targetNamespace = "")
                    String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getRoleByUser", targetNamespace = "http://webService.ims.com/", className = "com.ims.webService.GetRoleByUser")
    @ResponseWrapper(localName = "getRoleByUserResponse", targetNamespace = "http://webService.ims.com/", className = "com.ims.webService.GetRoleByUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<com.ims.webService.Role> getRoleByUser(
            @WebParam(name = "arg0", targetNamespace = "")
                    com.ims.webService.User arg0
    );
}