#axis1.4服务端
note：了解即可，不用做深入了解，现在都用2了
服务端发布不做代码示例，太复杂，谁会用啊，
    3种发布服务方式：
        1.即时发布jws，不做代码示例
        2.定制发布wsdl
        3.可以与web项目整合，不做代码示例
1.即时发布与访问
    1.服务端即时发布
        不做代码示例，只能有源码才能发布
        1.官网下载axis1.4，把webapp目录下的axis文件夹放到tomcat的webapp下
            启动tomcat，输入地址http://localhost:8080/axis/
        2.普通Java类的源文件的扩展名改为.jws，放到%tomcat_home%/webapps/axis/ 目录下
            不能包含包名，package 不能包含
            导入的话，貌似不能导入java自己的包之外的包
        3.访问地址http://ip:8080/axis/SayHello.jws?wsdl
    2.客户端访问：使用 Dynamic Invocation Interface ( DII) 方式访问 
        Service service = new Service();
        Call call = (Call) service.createCall();        
        call.setOperationName(method);  // 调用方法名 String
        call.setTargetEndpointAddress(webUrl);  // 访问路径 http://ip:8080/axis/SayHello.jws  String
        String val = (String) call.invoke(parameters); //方法传递参数  new Object[] { 参数... };
2.定制发布与访问
    1.服务端定制发布：不做代码示例，有clsaaes文件才能发布
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
    2.2访问定制发布的服务 
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
            //HelloServiceSoap11BindingStub和HelloServiceSoap12BindingStub 都可以使用使用
            ***Locator locator = new ***Locator();
            /*HelloServiceSoap12BindingStub stub =
                    new HelloServiceSoap12BindingStub(new URL(locator.getHelloServiceHttpSoap11EndpointAddress()), new
                         org.apache.axis.client.Service());*/
            HelloServiceSoap11BindingStub stub =
                    new HelloServiceSoap11BindingStub(new URL(locator.getHelloServiceHttpSoap12EndpointAddress()), new
                         org.apache.axis.client.Service());
            System.out.println(stub.sayHello());
3.与web项目整合
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
           
#axis1.4客户端   
    生成代码使用
        
   
