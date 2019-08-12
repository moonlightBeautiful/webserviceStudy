webService：
    通过HTTP协议发送请求和接收结果。
    发送的请求内容和接收的结果内容都采用XML格式封装，并增加了一些特定的HTTP消息头，以说明HTTP消息的内容格式。
    这些特定的HTTP消息头和XML内容格式就是SOAP协议。SOAP提供了标准的RPC方法来调用Web Service。
    SOAP协议 = HTTP协议 + XML数据格式。
    打个比喻：HTTP就是普通公路，XML就是中间的绿色隔离带和两边的防护栏，SOAP就是普通公路经过加隔离带和防护栏改造过的高速公路。
    WSDL(Web Services Description Language)是一个基于XML的语言，用于描述Web Service及其函数、参数和返回值。
    WSDL文件保存在Web服务器上，通过一个url地址就可以访问到它。客户端要调用一个WebService服务之前，要知道该服务的WSDL文件的地址。
webService组件：
    cxf、axis1和axis2等
