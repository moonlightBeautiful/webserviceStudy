package com.java1234.webservice.clientNet01;

import com.java1234.webservice.clientNet01.WeatherWSLocator;
import com.java1234.webservice.clientNet01.WeatherWSSoap_BindingStub;

import java.net.URL;

/**
 * Hello world!
 */
public class AppTest {
    public static void main(String[] args) throws Exception {
        // 关于天气的服务接口的调用http://www.webxml.com.cn/WebServices/WeatherWS.asmx
        WeatherWSLocator locator = new WeatherWSLocator();
        //***Soap_BindingStub和***Soap12Stub 都可以使用
      /*  WeatherWSSoap_BindingStub stub =
                new WeatherWSSoap_BindingStub(new URL(locator.getWeatherWSSoapAddress()), new
                        org.apache.axis.client.Service());*/
        WeatherWSSoap12Stub stub =
                new WeatherWSSoap12Stub(new URL(locator.getWeatherWSSoap12Address()), new
                        org.apache.axis.client.Service());
        stub.setTimeout(1000000);
        for (String str : stub.getRegionCountry()) {
            System.out.println(str);
        }

    }
}
