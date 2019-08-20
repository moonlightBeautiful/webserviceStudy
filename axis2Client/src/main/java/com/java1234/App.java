package com.java1234;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import javax.xml.namespace.QName;

/**
 * Hello world!
 */
public class App {
    /**
     * wsdl地址
     */
    public static final String targetEndpoint = "http://localhost:8099/services/HelloService?wsdl";
    public static final String targetNamespace = "http://impl.service.java1234.com";
    public static final String method = "sayHello";

    public static void main(String[] args) {
        try {
            //远程服务调用客户端
            RPCServiceClient rpcServiceClient = new RPCServiceClient();
            //远程服务调用客户端设置
            Options options = rpcServiceClient.getOptions();
            //设置wsdl地址
            options.setTo(new EndpointReference(targetEndpoint));
           //设置调用服务接口超时时间
            options.setTimeOutInMilliSeconds(1000 * 60 * 5);

            //invokeBlocking方法有三个参数
            // 第一个参数的类型是QName对象，表示要调用的方法名
            //      第一个参数表示WSDL文件的命名空间名，也就是<wsdl:definitions>元素的targetNamespace属性值，
            //      第二个参数是方法名<wsdl:binding>的子元素<wsdl:operation>的name属性值。
            QName opName = new QName(targetNamespace, method);
            // 第二个参数表示要调用的WebService方法的参数值，参数类型为Object[]；
            Object[] parameters = {};
            // 第三个参数表示WebService方法的返回值类型的Class对象，参数类型为Class[]。
            Class[] returnTypes = new Class[]{String.class};
            Object[] returnResults = rpcServiceClient.invokeBlocking(opName, parameters, returnTypes);
            System.out.println((String) returnResults[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
