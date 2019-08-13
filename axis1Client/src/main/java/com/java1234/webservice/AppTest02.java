package com.java1234.webservice;

import com.java1234.webservice.clientTest02.WeatherWSLocator;
import com.java1234.webservice.clientTest02.WeatherWSSoap12Stub;

import java.net.URL;

/**
 * Hello world!
 */
public class AppTest02 {
    public static void main(String[] args) throws Exception {
        // 关于天气的服务接口的调用
        WeatherWSLocator locator = new WeatherWSLocator();
        //HelloServiceSoap11BindingStub和HelloServiceSoap12BindingStub 一样使用
        /*HelloServiceSoap12BindingStub stub =
                new HelloServiceSoap12BindingStub(new URL(locator.getHelloServiceHttpSoap11EndpointAddress()), new
                        org.apache.axis.client.Service());*/
        WeatherWSSoap12Stub stub =
                new WeatherWSSoap12Stub(new URL(locator.getWeatherWSSoap12Address()), new
                        org.apache.axis.client.Service());
        for (String str : stub.getRegionCountry()) {
            System.out.println(str);
        }

    }
}
