package com.ims;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import javax.jws.WebService;
import javax.xml.namespace.QName;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws AxisFault {
        // 使用RPC方式调用WebService
        RPCServiceClient serviceClient = new RPCServiceClient();
        // 配置serviceClient
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR = new EndpointReference("http://localhost:8080/c04axis2ServerInWebAndTomcat/services/HelloService?wsdl");
        options.setTo(targetEPR);  // 指定调用WebService的URL

        /**
         * 调用方法一 (方法，入参)
         *      获取服务返回结果集
         */
        /*QName qname = new QName("http://impl.service.ims.com", "sayHello");// 指定WSDL文件的命名空间和调用方法
        Object[] parameters = new Object[]{}; // 调用方法的入参
        OMElement element = serviceClient.invokeBlocking(qname, parameters);
        //值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。取第一个元素值，并打印之。因为调用的方法返回一个结果
        String result = element.getFirstElement().getText();
        System.out.println(result);*/

        /**
         * 调用方法二(方法，入参，返回类型)
         */
        QName qname = new QName("http://impl.service.ims.com", "sayHelloToPerson");// 指定WSDL文件的命名空间和调用方法
        Object[] parameters = new Object[]{"高旭"}; // 调用方法的入参
        Class[] returnTypes = new Class[] { String.class }; // 调用方法的返回数据类型，Class对象
        Object[] response = serviceClient.invokeBlocking(qname, parameters, returnTypes);
        String r = (String) response[0];
        System.out.println(r);


        /**
         * RPCServiceClient继承于父类serviceClient对父类进行拓展，
         * 我们可以直接拿着serviceClient进行操作实现我们的需求
         */
    }
}
