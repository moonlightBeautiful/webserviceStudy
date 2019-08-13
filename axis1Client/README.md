axis1.4客户端使用：
    1.pom导入axis1.4的jar包
    2.拷贝生成的客户端代码到项目中：
        生成代码操作：
            官网下载、解压axis1.4。额外需要jar包mail和activation要放到axis1.4解压包下的lib目录下
            使用脚本生成客户端代码，把代码复制到项目中。
                ::axis.jar所在目录
                set axis_Lib=D:\apache-axis-1_4\lib
                ::生成客户端的代码所在文件夹
                set output_Path=F:\my
                ::生成客户端的代码所在包
                set package=com.java1234.webservice.client  
                ::wsdl地址
                set wsdlAdress=http://localhost:8090/services/HelloService?wsdl
                set java_Cmd=java -Djava.ext.dirs=%Axis_Lib%
                %java_Cmd% org.apache.axis.wsdl.WSDL2Java -o %output_Path% -p %package% %wsdlAdress%
                pause;
    3.调用服务接口
        HelloServiceLocator locator = new HelloServiceLocator();
        //HelloServiceSoap11BindingStub和HelloServiceSoap12BindingStub 一样使用
        /*HelloServiceSoap12BindingStub stub =
                new HelloServiceSoap12BindingStub(new URL(locator.getHelloServiceHttpSoap11EndpointAddress()), new
                     org.apache.axis.client.Service());*/
        HelloServiceSoap11BindingStub stub =
                new HelloServiceSoap11BindingStub(new URL(locator.getHelloServiceHttpSoap12EndpointAddress()), new
                     org.apache.axis.client.Service());
        System.out.println(stub.sayHello());
        System.out.println(stub.sayHelloToPerson("lizhuguan"));