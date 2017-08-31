package com.hfzs.biz.sys.domain;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

/**
 * 用户信息.
 * @author Angel(QQ:412887952)
 * @version v.0.1
 */
@Entity
@Table(name = "t_sys_user_info")
public class UserInfo implements Serializable{
    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String uid;//用户id;

    @Column(unique=true)
    private String loginName;//账号.

    private String name;//名称（昵称或者真实姓名，不同系统不同定义）

    private String password; //密码;

    private String salt;//加密密码的盐

    private String mobile;

    @Column(columnDefinition="enum('男','女')")
    private String sex;

    private byte state;//用户状态,0:创建未认证（比如没有激活，没有输入验证码等等）--等待验证的用户 , 1:正常状态,2：用户被锁定.

    @ManyToMany  //(fetch=FetchType.LAZY)//;
    @JoinTable(name = "t_sys_user_role", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private Set<SysRole> roleList;// 一个用户具有多个角色

    @ManyToOne         //部门
    @JoinColumn(name="dept_id")
    private Dept dept;

    public Set<SysRole> getRoleList() {
        return roleList;
    }
    public void setRoleList(Set<SysRole> roleList) {
        this.roleList = roleList;
    }

    public String getUid() {
        return uid;
    }
    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }
    public void setSalt(String salt) {
        this.salt = salt;
    }

    public byte getState() {
        return state;
    }
    public void setState(byte state) {
        this.state = state;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.loginName +this.salt;
    }

    @Override
    public String toString() {
        return "UserInfo [uid=" + uid + ", loginName=" + loginName + ", name=" + name + ", password=" + password
                + ", salt=" + salt + ", state=" + state + "]";
    }


}