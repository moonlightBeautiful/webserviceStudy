webService：
简介
    是一种跨编程语言、跨操作系统平台的远程调用技术。
        远程调用技术：
            一台设备上的程序A可以调用另一台设备上程序B暴露的方法。比如：pos刷卡系统。
        跨编程语言：
            服务端、客户端程序的编程语言可以不同。
        跨操作系统平台：
            服务端、客户端可在不同的操作系统上运行。
    远程调用过程：
        客户端向服务端发送服务请求，服务端接收请求并处理，再向客户端回复请求，客户端接收回复。
        请求和回复各自表现为一组数据，数据具有某种表示形式（XML）和类型标准（XSD），数据通过某传输协议（HTTP）通过网络进行传输。
    如何调用WebService服务端api：
        WebService服务端通过一个文件（XML）描述服务端开放的API。
            来说明自己家里有啥服务可以对外调用，服务是什么（服务中有哪些方法，方法接受 的参数是什么，返回值是什么），服务的网络地址用哪个url地址表示，服务通过什么方式来调用。
        WSDL(Web Services Description Language)是一个基于XML来描述服务端开放的API的语言。描述语言
            用于描述Web Service及其函数、参数和返回值。是WebService客户端和服务器端都能理解的标准语言。
        WSDL 文件保存在Web服务器上，通过一个url地址就可以访问到它。
        客户端要调用一个WebService服务之前，要知道该服务的WSDL文件的地址。
    通信协议
        SOAP的传输协议使用的就是HTTP协议，在HTTP协议的Post方法上改造的。传输协议。
        在HTTP协议的post方法的请求头中加入SOAPAction这一属性之后HTTP协议就变成了SOAP协议。SOAP的内容是XML格式的数据。
        请求
            <?xml version="1.0" encoding="utf-8"?>
            <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
                <soap:Body>
                    <getSupportCity xmlns="http://WebXml.com.cn/">
                        <byProvinceName>广东</byProvinceName>
                    </getSupportCity>
                </soap:Body>
            </soap:Envelope>
            说明
                <soap:Body>里面的内容就是请求的内容
                    请求的方法为getSupportCity，参数名为byProvinceName，值为“广东”。                  
webService实现组件：
    cxf、axis1和axis2等 JDK也自带了实现
  
JDK：依赖jdk1.6以上
    服务端  
        1.service和impl类上+注解@WebService
        2.发布服务：
            HelloService helloService = new HelloServiceImpl();  //需要对外公开的服务类
            String address = "http://192.168.1.33/service/helloService"; //服务地址 本机ip
            Endpoint.publish(address, helloService); //开始暴露webservice接口
        3.wsdl地址：http://192.168.1.33/service/helloService?wsdl
    客户端
        1.使用JDK自带的工具wsimport解析WSDL文件生成代码
            wsimport -s F:\\java -p com.ims.webService -keep http://192.168.1.33/service/helloService?wsdl
                -d：指定.class文件输出目录   -d F:\\src
                -s：指定.java文件输出目录
                -p：以package的形式生成文件
                -keep：是否生成java源文件
        2.把生成的代码复制到象奴中开始调用服务
            HelloServiceImplService helloServiceImplService = new HelloServiceImplService();
            HelloServiceImpl helloService = helloServiceImplService.getHelloServiceImplPort();
            System.out.println(helloService.say("大爷"));
cxf：
    服务端
        1.引入依赖的3个jar包
        2.service和impl类上+注解@WebService
        3.发布服务：JaxWsServerFactoryBean
        4.wsdl地址：http://192.168.1.33/service/helloService?wsdl    
        数据类型
            1.基本、List、javabean和本地没啥区别
            2.返回参数是Map，需要适配器。好复杂，算了。
        拦截器：拦截发布的方法，先进后出。
            添加拦截器，可以断不需要重新解析wsdl。
            1.内置拦截器
            2.自定义拦截器，可以获取消息头数据
                继承AbstractPhaseInterceptor<SoapMessage>
                1.构造方法：定义拦截机器类型，
                    有很多种，用到的时候百度吧
                2.实现方法：handleMessage(SoapMessage soapMessage) 
                    soapMessage可 获取头消息 
        springMVC整合cxf，也就是spring来自动发布webservice
            1.引入相关jar包
            2.web.xml配置
                1.加载spring 监听器和配置文件
                2.使用CXFServlet处理调用发布服务的请求
            3.编码service类和拦截器类
            4.spring的xml文件配置
                1.引入cxk的xml文件，为了spring来实例化bean
                    cxf-core和cxf-rt-transports-http的jar包可以看到引入的xml文件
                2.实例化bean发布服务实现类
                3.定义发布者
                    发布服务实现类实例，服务地址（要拼接web.xml中CXF请求后面）
            5.客户端要根据wsdl从新生成下代码，调用方式和原来一样
    客户端
        1.cxf解析wsdl，官网下载
            1.环境变量配置，可以不配置，需要进入到cxf的bin目录下执行
                CXF_HOME    D:\apache-cxf-3.1.5
                Path        ;%CXF_HOME%\bin
            2.cmd中使用cxf解析wsdl生成代码
                wsdl2java -d F:\\java -p com.ims.webService com. http://ip地址/服务?wsdl
                    -d 输出目录               
            3.把生成的代码复制到包中开始调用服务：如果不使用cxf其他功能拦截器等，不需要引入cxf包
                HelloServiceService helloServiceService = new HelloServiceService();
                HelloService helloService = helloServiceService.getHelloServicePort();
                System.out.println(helloService.say("大爷"));        
        拦截器：拦截调用发布方法，先出后进
            添加拦截器，可以断不需要重新解析wsdl。
            客户端也可以添加拦截器
                类型有很多种，用到的时候百度吧
                1.内置拦截器
                2.自定义拦截器，可以向消息头添加数据
                    继承AbstractPhaseInterceptor<SoapMessage>
                    1.构造方法：定义拦截机器类型，
                        有很多种，用到的时候百度吧
                    2.实现方法：handleMessage(SoapMessage soapMessage) 
                        soapMessage可 获取头消息    
3.axis1.4
    3种发布服务方式：
        1.pojo即时发布jws，不做代码示例
        2.定制发布wsdl，不做代码示例
        3.整合到web项目中发布，其实就是第2种的整合
    2种调用服务方式
        1. (DII) 方式访问 ，不用生成代码，貌似能访问第一种发布方式，没测试。
        2. 生成客户端代码访问 根据wsdl文件上生成
    服务端发布服务
        1.即时发布与访问
            不做代码示例，只能有源码才能发布
            1.官网下载axis1.4，把webapp目录下的axis文件夹放到tomcat的webapp下
                启动tomcat，输入地址http://localhost:8080/axis/
            2.普通Java类的源文件的扩展名改为.jws，放到%tomcat_home%/webapps/axis/ 目录下
                不能包含包名，不能使用package关键字声明包
                导入的话，貌似不能导入java自己的包之外的包
            3.访问地址http://ip:8080/axis/SayHello.jws?wsdl
        2.定制发布
            不做代码示例，有clsaaes文件才能发布
            1.发布服务类.class文件复制到%tomcat_home%/axis/WEB-INF/class/ 目录下，包也要复制过来，带包复制
            2.创建wsdd 文件
                创建deploy.wsdd 文件，用于发布服务，内容如下
                    <deployment name="test" xmlns="http://xml.apache.org/axis/wsdd/"
                        xmlns:java="http://xml.apache.org/axis/wsdd/providers/java">
                        <service name="服务名，随便娶" provider="java:RPC" style="rpc" use="encoded">
                            <parameter name="className" value="服务类名，全路径带包路径"/>
                            <parameter name="allowedMethods" value="*"/>
                             <typeMapping xmlns:ns1="http://wsaxis.michael.com" qname="ns1:userBean"
                                 type="java:参数全路径类名"
                                 serializer="org.apache.axis.encoding.ser.BeanSerializerFactory"
                                 deserializer="org.apache.axis.encoding.ser.BeanDeserializerFactory"
                                 encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"/>
                        </service>
                    </deployment>
                创建一个 undeploy.wsdd 文件, 该文件主要用于取消发布的服务，可以不取消
                    <undeployment xmlns="http://xml.apache.org/axis/wsdd/">
                        <service name="服务名"/>
                    </undeployment>
            3.生成server-config.wsdd 文件
                打开cmd进入 %tomcat_home%/axis/WEB-INF/ 目录下，如下命令
                java -Djava.ext.dirs=lib org.apache.axis.client.AdminClient -p 8080 deploy.wsdd   
                java -Djava.ext.dirs=lib org.apache.axis.client.AdminClient -p 8080 -s /axis/servlet/AxisServlet deploy.wsdd
                java -Djava.ext.dirs=lib org.apache.axis.client.AdminClient –l http://localhost:8080/axis/services/MessageService deploy.wsdd
                验证是否发布成功：
                    看下 %tomcat_home%/axis/WEB-INF/  目录下是否已经生成 server-config.wsdd 文件
                    http://localhost:8080/axis/services/MessageService 
            4.通过WSDD文件卸载发布的服务：
                cmd进入%tomcat_home%/axis/WEB-INF/
                命令：java -Djava.ext.dirs=lib org.apache.axis.client.AdminClient -p tomcat端口号 undeploy.wsdd
        3.整合到web项目中发布
            1.axis-1_4\lib所有jar包到server\WebRoot\WEB-INF\lib
            2.web项目的WEB-INF下新增server-config.wsdd
                配置webservice类
            3.web.xml添加
                 <servlet>  
                     <servlet-name>AxisServlet</servlet-name>  
                     <servlet-class>org.apache.axis.transport.http.AxisServlet</servlet-class>  
                 </servlet>  
                 <servlet-mapping>  
                     <servlet-name>AxisServlet</servlet-name>  
                     <url-pattern>/services/*</url-pattern>  
                 </servlet-mapping>   
            4.编写webservice类和方法
            5.访问发布的服务
                http://localhost:8080/server/services  
            6.客户端访问，也是2那样生成的代码访问，和2没什么区别，只是2整合到了web中   
    客户端访问服务
        1.不用生成代码，但是不靠谱，我是没调通
            Service service = new Service();
            Call call = (Call) service.createCall();        
            call.setOperationName(method);  // 调用方法名 String
            call.setTargetEndpointAddress(webUrl);  // 访问路径 http://ip:8080/axis/SayHello.jws  String
            String val = (String) call.invoke(parameters); //方法传递参数  new Object[] { 参数... };
        2.生成客户端代码调用服务
            1.axis1.4的lib目录下需要额外的jar包：mail和activation，如果没有则需要下载。
            2.创建bat文件，内容如下：
                ::配置axis.jar所在目录
                set axis_Lib=D:\apache-axis-1_4\lib
                ::配置生成客户端的代码所在文件夹
                set output_Path=F:\my
                ::配置生成客户端的代码包路径
                set package=com.java1234.webservice.client  
                ::配置wsdl地址
                set wsdlAdress=http://localhost:8090/services/HelloService?wsdl
                ::配置java执行命令
                set java_Cmd=java -Djava.ext.dirs=%Axis_Lib%
                ::执行命令，生成客户端代码
                %java_Cmd% org.apache.axis.wsdl.WSDL2Java -o %output_Path% -p %package% %wsdlAdress%
                pause;
            3.把生成的代码放到项目中，然后使用客户端代码访问服务
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
4.axis2
    3种发布服务方式：
        1.简单的pojo方式（无需配置），了解即可
        2.打aar包的方式，太复杂，了解即可
        3.整合到web项目中发布，其实就是第2种的整合
    3种调用服务方式
        1.RPC方式，不生成客户端代码
        2.document方式，不生成客户端代码
        3.用wsdl2java工具生成客户端方式      
    服务端发布服务
        1.简单的pojo方式
            1.官网下载axis2.war文件放到<Tomcat安装目录>\webapps目录中
                http://localhost:8080/axis2/ 验证
            2.把POJO类编译的class文件放到<Tomcat安装目录>\webapps\axis2\WEB-INF\pojo中（如果没有pojo目录，则建立该目录）
                POJO类不能使用package关键字声明包。
            3.启动tomcat
                http://localhost:8080/axis2/    页面中 点击Services 查看到发布的POJO类
                http://localhost:8080/axis2/services/Service类名/方法名?参数键值对1&参数键值对2
                Axis2在默认情况下可以热发布WebService，将WebService的.class文件复制到pojo目录中时，
                Tomcat不需要重新启动就可以自动发布WebService。
        2.打aar包的方式
            1.需要服务类class文件和services.xml文件，services.xml文件配置服务
                文件按照指定目录放
                    D:\项目名\包路径com\sinosoft\webservice\服务类.class
                    D:\项目名\META-INF必须这个目录\services.xml
            2.打包
                在windows控制台中进入项目名目录，并输入如下的命令生成.aar文件.
                jar cvf ws.aar .(注意：最后面是空格+小数点)
            3.最后将项目名.aar文件复制到<Tomcat安装目录>\webapps\axis2\WEB-INF\services目录中 
            4.启动Tomcat后，就可以调用这个WebService了
        3.整合到web项目中发布
            1.引入axis2需要的jar包
            2.war包下的
                axis2-web放到web项目点的Webapp下
                将WEB-INF 下的 lib 、conf  、modules、views等文件夹移动到 AxisWebDemo工程的 WEB-INF目录下
                启动后，如果报缺少哪个，继续去 WEB-INF 下找
            3.配置web.xml，增加AxisServlet处理请求
            4.写一个简单的web服务类
            5.在/WEB-INF目录下创建相应的文件夹和services.xml,配置要发布的服务类
                目录层次必须是  services / 任意名称文件夹  / META-INF / services.xml 
                可以部署多个服务，在serviceGroup中写多个service
                也可以只部署一个服务，单个service为根节点
            6.浏览器
                http://localhost:8080/项目名/web.xml配置的services/listServices
                wsdl文件：http://localhost:8080/项目名/web.xml配置的services/myService?wsdl
            note:
                与spring整合的话，很简单
                其他web.xml和spring.xml对axis2和spring的配置和原来都一样。
                额外需要：
                    1.spring.xml增加如下：spring来管理axis2
                        <bean id= "applicationContext" class = "org.apache.axis2.extensions.spring.receivers.ApplicationContextHolder"  />
                    2.services.xml使用
                        <!-- 通过ServiceObjectSupplier参数指定SpringServletContextObjectSupplier类来获得Spring的ApplicationContext对象 -->
                        <parameter name="ServiceObjectSupplier" locked="false">
                            org.apache.axis2.extensions.spring.receivers.SpringServletContextObjectSupplier
                        </parameter>
    客户端调用服务
        1.RPC方式
            1.RPCServiceClient
            2.Options
            3.RPCServiceClient设置Options
            4.QName、Object[] parameters、Class[] returnTypes
            5.Object[] response = serviceClient.invokeBlocking(qname, parameters, returnTypes);
        2.document方式
            看了网上的教程 方正我是没调通
        3.用wsdl2java工具生成客户端方式 
            1.进入到axis2的bin目录下 
                wsdl2java -uri http://localhost:8080/c04axis2ServerInWebAndTomcat/services/HelloService?wsdl -p com.ims.webService.client -s -o stub
                    -uri：wsdl文件的路径
                    -p：指定代码的package名称
                    -o：根目录，当前目录下生成stub目录。
            2.生成的客户端代码复制到项目中使用
                HelloServiceStub stub = new HelloServiceStub();
                HelloServiceStub.SayHelloToPerson sayHelloToPerson = new HelloServiceStub.SayHelloToPerson();
                sayHelloToPerson.setName("高旭"); //入参
                HelloServiceStub.SayHelloToPersonResponse resp = stub.sayHelloToPerson(sayHelloToPerson);
                String ret = resp.get_return();
                System.out.println(ret); 