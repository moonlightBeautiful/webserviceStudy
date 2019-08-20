axis1.4客户端使用：
    1.pom导入axis1.4的jar包
    2.不用生成客户端代码，知道三个参数就可以
        public static final String targetEndpoint = "http://localhost:8080/services/HelloService?wsdl";
        public static final String targetNamespace = "http://impl.service.java1234.com";
        public static final String method = "sayHello";
    