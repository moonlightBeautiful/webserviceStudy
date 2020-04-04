package com.ims;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class App {

    public static void main(String[] args) throws MalformedURLException, RemoteException, ServiceException {
        /*WeatherWebServiceLocator weatherWebServiceLocator = new WeatherWebServiceLocator();
         *//*WeatherWebServiceSoap12Stub stub =
                new WeatherWebServiceSoap12Stub(new URL(weatherWebServiceLocator.getWeatherWebServiceSoap12Address()), new
                        org.apache.axis.client.Service());*//*
        WeatherWebServiceSoap_BindingStub stub = new WeatherWebServiceSoap_BindingStub(new URL(weatherWebServiceLocator.getWeatherWebServiceSoapAddress()),
                new org.apache.axis.client.Service());
        stub.setTimeout(1000 * 40);
        for (String str : stub.getSupportProvince()) {
            System.out.println(str);
        }*/


        /**
         * 下面这种方法调试不同
         */
        /*String endpoint = "http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(endpoint);
        call.setOperationName("getSupportProvince");
        call.setTimeout(10000);  //单位是毫秒
        Object[] parameters = new Object[]{  };  // 入参参数是数组类型，也就是参数个数
        *//*call.addParameter();*//*
        System.out.println(call.invoke(parameters));*/

    }
}
