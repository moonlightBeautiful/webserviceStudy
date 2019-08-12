package com.java1234.webservice.impl;

import com.java1234.webservice.HelloWorldService;

/**
 * @author gaoxu
 * @date 2019-05-20 18:03
 * @description ... 类
 */
public class HelloWorldServiceImpl implements HelloWorldService {
    /**
     * 模拟要暴露的接口：返回hello:+传入的参数
     * @param str
     * @return
     */
    @Override
    public String say(String str) {
        System.out.println("我被" + str + "调用了");
        return "hello：" + str;
    }

    /**
     * 返回数据类型是List<javabean>
     */
    /*@Override
    public List<Role> getRoleByUser(User user) {
        List<Role> roleList = new ArrayList<Role>();
        // 模拟  直接写死
        if (user != null) {
            if (user.getUserName().equals("java1234") && user.getPassword().equals("123456")) {
                roleList.add(new Role(1, "技术总监"));
                roleList.add(new Role(2, "架构师"));
            } else if (user.getUserName().equals("jack") && user.getPassword().equals("123456")) {
                roleList.add(new Role(3, "程序员"));
            }
            return roleList;
        } else {
            return null;
        }
    }*/

    /**
     * 返回数据类型是Map<String, List<javabean>>
     */
    /*@Override
    public Map<String, List<Role>> getRoles() {
        Map<String, List<Role>> map = new HashMap<String, List<Role>>();
        List<Role> roleList1 = new ArrayList<Role>();
        roleList1.add(new Role(1, "技术总监"));
        roleList1.add(new Role(2, "架构师"));
        map.put("java1234", roleList1);

        List<Role> roleList2 = new ArrayList<Role>();
        roleList2.add(new Role(3, "程序员"));
        map.put("jack", roleList2);

        return map;
    }*/

}
