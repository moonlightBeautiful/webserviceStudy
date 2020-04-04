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