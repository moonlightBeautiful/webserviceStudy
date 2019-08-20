webService：
    通过HTTP POST协议发送请求和接收结果。
        •text/xml 这是基于soap1.1协议。
        •application/soap+xml 这是基于soap1.2协议。
    发送的请求内容和接收的结果内容都采用XML格式封装，并增加了一些特定的HTTP消息头，以说明HTTP消息的内容格式。
    这些特定的HTTP消息头和XML内容格式就是SOAP协议。SOAP提供了标准的RPC方法来调用Web Service。
    SOAP协议 = HTTP协议 + XML数据格式。
    打个比喻：HTTP就是普通公路，XML就是中间的绿色隔离带和两边的防护栏，SOAP就是普通公路经过加隔离带和防护栏改造过的高速公路。
    WSDL(Web Services Description Language)是一个基于XML的语言，用于描述Web Service及其函数、参数和返回值。
    WSDL文件保存在Web服务器上，通过一个url地址就可以访问到它。客户端要调用一个WebService服务之前，要知道该服务的WSDL文件的地址。
    基于SOAP1.1生成的WSDL和基于SOAP1.2生成的WSDL也不一样：
    J2EE里面的stub是这样说的：为屏蔽客户调用远程主机上的对象，必须提供某种方式来模拟本地对象，这种本地对象称为存根(stub)，存根负责接收本地方法调用，并将它们委派给各自的具体实现对象。
webService组件：
    cxf、axis1和axis2等
    
编码：
    1.cxf（单独使用、在springWebApp中使用）发布服务，cxf（单独使用）调用服务
        发布服务：2个参数
            1.暴露接口的类
            2.暴露接口的ip地址：String address = "http://localhost/helloWorld";
        使用服务：
            1.生成客户端代码
            2.调用服务
    2.axis2（单独使用、在WebApp中使用，都需要用到axis2-web）发布服务，axis1和axis2调用服务
        axis2发布服务
            1.使用集成在webApp中方式
        axis2使用服务
            1.不用生成客户端代码，需要三个参数
                 1.wsdl地址：targetEndpoint = "http://localhost:8099/services/HelloService?wsdl";
                 2.命名空间：targetNamespace = "http://impl.service.java1234.com";
                 3.方法名：method = "sayHello";
        axis1使用服务：
            1.生成客户端代码：如果发布的服务的方法名上抛出了异常，则可能会出错
            2.调用