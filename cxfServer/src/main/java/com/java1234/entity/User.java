package com.java1234.entity;

/**
 * @author gaoxu
 * @date 2019-05-30 16:57
 * @description ... 类
 */
public class User {
    private Integer id; // 编号
    private String userName; // 用户名
    private String password; // 密码

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
