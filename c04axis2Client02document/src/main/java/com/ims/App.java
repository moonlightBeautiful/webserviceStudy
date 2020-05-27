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
        EndpointReference targetEPR = new EndpointReference("http://localhost:8080/c04axis2ServerInWebAndTomcat/services/HelloService?wsdl");
        options.setTo(targetEPR);  // 指定调用WebService的URL
        // 保存选项
        serviceClient.setOptions(options);
        // 命名空间
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://impl.service.ims.com", "sayHello");
        OMElement method = fac.createOMElement("sayHello", omNs);
        // 对应WebService的方法参数的节点
        String[] strs = new String[]{"name"};
        // 参数值
        String[] val = new String[]{"admin"};
        for (int i = 0; i < strs.length; i++) {
            OMElement inner = fac.createOMElement(strs[i], omNs);
            inner.setText(val[i]);
            method.addChild(inner);
        }
        method.build();
        OMElement result = serviceClient.sendReceive(method);
        System.out.println(result.getFirstElement().getText());
    }
}
