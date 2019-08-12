package com.java1234.webservice.impl;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import com.java1234.webservice.HelloWorldService;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2019-08-12T14:35:10.786+08:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "HelloWorldServiceImplService", 
                  wsdlLocation = "http://10.0.102.142/helloWorld?wsdl",
                  targetNamespace = "http://impl.webservice.java1234.com/") 
public class HelloWorldServiceImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://impl.webservice.java1234.com/", "HelloWorldServiceImplService");
    public final static QName HelloWorldServiceImplPort = new QName("http://impl.webservice.java1234.com/", "HelloWorldServiceImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://10.0.102.142/helloWorld?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HelloWorldServiceImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://10.0.102.142/helloWorld?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HelloWorldServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HelloWorldServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HelloWorldServiceImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public HelloWorldServiceImplService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HelloWorldServiceImplService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HelloWorldServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns HelloWorldService
     */
    @WebEndpoint(name = "HelloWorldServiceImplPort")
    public HelloWorldService getHelloWorldServiceImplPort() {
        return super.getPort(HelloWorldServiceImplPort, HelloWorldService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HelloWorldService
     */
    @WebEndpoint(name = "HelloWorldServiceImplPort")
    public HelloWorldService getHelloWorldServiceImplPort(WebServiceFeature... features) {
        return super.getPort(HelloWorldServiceImplPort, HelloWorldService.class, features);
    }

}
