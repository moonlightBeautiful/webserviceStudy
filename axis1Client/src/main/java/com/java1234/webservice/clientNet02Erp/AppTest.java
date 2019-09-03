package com.java1234.webservice.clientNet02Erp;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author gaoxu
 * @date 2019-09-03 14:31
 * @description ... 类
 */
public class AppTest {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        String dwbh = "6"; // 单位编号
        String state = "1"; // 获取方式，0：全部获取，1：增量获取
        String instanceid = "213"; // 实例编号
        String userCode = "aa"; // 用户名
        String password = "aa"; // 密码
        String startTime = "2019-01-01"; // 开始时间
        String endTime = "2019-01-01"; // 结束时间
        String kind = "1"; // 类型

        AVMPMInterfaceLocator locator = new AVMPMInterfaceLocator();
        AVMPMInterfaceSoap12Stub stub = new AVMPMInterfaceSoap12Stub(new URL(locator.getAVMPMInterfaceSoap12Address()), new org.apache.axis.client.Service());
        System.out.println("开始时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        stub.setTimeout(1000 * 60 * 1);
        try {
            stub.getComMaterials(dwbh, state, startTime, kind, instanceid, endTime, userCode, password);
            System.out.println("结束时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
        } catch (RemoteException e) {
            System.out.println("结束时间：" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            e.printStackTrace();
        }

    }
}
