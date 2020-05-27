package com.ims;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws AxisFault {
        // 使用document方式调用serviceClient
        ServiceClient serviceClient = new ServiceClient();
        // 配置serviceClient选项
        Options options = new Options();
        EndpointReference targetEPR = new EndpointReference("http://localhost:8080/c04axis2Server02InSpringMVCAndTomcat_war_exploded/services/HelloWorldService?wsdl");
        // 指定调用WebService的URL
        options.setTo(targetEPR);
        // 保存选项
        serviceClient.setOptions(options);
        // 命名空间
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://impl.service.ims.com", "sayHiToUser");
        OMElement method = fac.createOMElement("sayHiToUser", omNs);
        // 参数值
        OMElement inner = fac.createOMElement("name", omNs);
        inner.setText("admin");
        method.addChild(inner) ;
        method.build();
        OMElement result = serviceClient.sendReceive(method);
        System.out.println(result.getFirstElement().getText());
    }
}
