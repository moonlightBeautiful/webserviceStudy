#.axis2 3.生成的客户端代码复制到项目中使用
1.生成客户端代码
    进入到D:\apache-axis2-1.7.9\bin，后执行
    wsdl2java -d F:\\java -p com.ims.webService http://192.168.1.3/service/helloService?wsdl
2.调用
    HelloServiceStub stub = new HelloServiceStub();
    HelloServiceStub.SayHelloToPerson sayHelloToPerson = new HelloServiceStub.SayHelloToPerson();
    sayHelloToPerson.setName("高旭"); //入参
    HelloServiceStub.SayHelloToPersonResponse resp = stub.sayHelloToPerson(sayHelloToPerson);
    String ret = resp.get_return();
    System.out.println(ret);    