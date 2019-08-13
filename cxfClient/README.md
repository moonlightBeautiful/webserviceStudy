cxf学习：
    1.调用服务器发布的服务（必须根据wsdl地址生成客户端代码，地址改变就必须从新生成）
       1.配置好cxf，官网下载，配置环境变量
            CXF_HOME    D:\apache-cxf-3.1.5
            Path        ;%CXF_HOME%\bin
       2.需要服务器WSDL文件的url地址
             http://10.0.102.142/helloWorld?wsdl
       3.cmd生成客户端代码
            打开cmd进入到一个目录执行下面命令
            wsdl2java http://ip地址/helloWorld?wsdl
       4.调用服务端方法
            
       