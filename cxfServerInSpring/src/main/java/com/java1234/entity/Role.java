package com.java1234.entity;

/**
 * @author gaoxu
 * @date 2019-05-30 16:57
 * @description ... 类
 */
public class Role {
    private Integer id; // 编号
    private String roleName; // 角色名称



    public Role() {
        super();
        // TODO Auto-generated constructor stub
    }


    public Role(Integer id, String roleName) {
        super();
        this.id = id;
        this.roleName = roleName;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
