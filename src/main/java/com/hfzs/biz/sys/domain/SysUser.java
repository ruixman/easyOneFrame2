package com.hfzs.biz.sys.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/9.
 */
@Entity
@Table(name = "T_SYS_USER_INFO")
public class SysUser {

        private String id;
        private String name;
        private String psw;
        private String loginName;
        private String type;
        private String typeName;
        private String roleName;
        private String tel;
        private String mobile;
        private String sex;
        private String sexName;
        private Date lastLoginTime;
        private Date loginTime;
        private java.sql.Date birthday;
        private String deptMsg;
        private String deptId;
        private String deptName;
        private String email;
        private String qq;
        private String alitalk;
        private String post;
        private String caCard;
        private String address;
        private Date createTime;
        private Date updateTime;
        private Integer flag = 0;
        private String createrId;
        private String updaterId;
        private String createrName;
        private String updaterName;
        private String ispNum;
        //	private String loginCA;
//	private String loginPWD;
        private String image01;
        private String image02;
        private String image03;
        private String image04;
        private String image05;
        private String registerId;
        private String auditorId;
        //	private String companyName;
        private Integer loginCA=1;
        private Integer loginPWD=0;


        @Column(name = "ISP_NUM", insertable = true, updatable = true)
        public String getIspNum() {
            return ispNum;
        }

        public void setIspNum(String ispNum) {
            this.ispNum = ispNum;
        }

        @Column(name = "CREATER_ID", insertable = true, updatable = true)
        public String getCreaterId() {
            return createrId;
        }

        public void setCreaterId(String createrId) {
            this.createrId = createrId;
        }

        @Column(name = "UPDATER_ID", insertable = true, updatable = true)
        public String getUpdaterId() {
            return updaterId;
        }

        public void setUpdaterId(String updaterId) {
            this.updaterId = updaterId;
        }

        @Column(name = "CREATER_NAME", insertable = true, updatable = true)
        public String getCreaterName() {
            return createrName;
        }

        public void setCreaterName(String createrName) {
            this.createrName = createrName;
        }

        @Column(name = "UPDATER_NAME", insertable = true, updatable = true)
        public String getUpdaterName() {
            return updaterName;
        }

        public void setUpdaterName(String updaterName) {
            this.updaterName = updaterName;
        }

        @Id
        @GeneratedValue(generator = "UIDGenerator")
        @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Column(name = "CREATE_TIME", insertable = true, updatable = true)
        public Date getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }

        @Column(name = "UPDATE_TIME", insertable = true, updatable = true)
        public Date getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }

        @Column(name = "PASSWORD", insertable = true, updatable = true)
        public String getPsw() {
            return psw;
        }

        public void setPsw(String psw) {
            this.psw = psw;
        }

        @Column(name = "LOGIN_NAME", insertable = true, updatable = true)
        public String getLoginName() {
            return loginName;
        }

        public void setLoginName(String loginName) {
            this.loginName = loginName;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Column(name = "DEPT_MSG", insertable = true, updatable = true)
        public String getDeptMsg() {
            return deptMsg;
        }

        public void setDeptMsg(String deptMsg) {
            this.deptMsg = deptMsg;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getAlitalk() {
            return alitalk;
        }

        public void setAlitalk(String alitalk) {
            this.alitalk = alitalk;
        }

        public String getPost() {
            return post;
        }

        public void setPost(String post) {
            this.post = post;
        }

        @Column(name = "CA_CARD", insertable = true, updatable = true)
        public String getCaCard() {
            return caCard;
        }

        public void setCaCard(String caCard) {
            this.caCard = caCard;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Integer getFlag() {
            return flag;
        }

        public void setFlag(Integer flag) {
            this.flag = flag;
        }

        @Column(name = "LAST_LOGIN_TIME", insertable = true, updatable = true)
        public Date getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public java.sql.Date getBirthday() {
            return birthday;
        }

        public void setBirthday(java.sql.Date birthday) {
            this.birthday = birthday;
        }

        @Column(name = "DEPT_ID", insertable = true, updatable = true)
        public String getDeptId() {
            return deptId;
        }

        public void setDeptId(String deptId) {
            this.deptId = deptId;
        }

        @Transient
        public String getDeptName() {
            return deptName;
        }

        public void setDeptName(String deptName) {
            this.deptName = deptName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        @Transient
        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }

        @Transient
        public String getSexName() {
            return sexName;
        }

        public void setSexName(String sexName) {
            this.sexName = sexName;
        }

        @Column(name = "LOGIN_TIME", insertable = true, updatable = true)
        public Date getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Date loginTime) {
            this.loginTime = loginTime;
        }

        @Transient
        public String getTypeName() {
            return typeName;
        }

        public void setTypeName(String typeName) {
            this.typeName = typeName;
        }


        @Column(name = "REGISTER_ID", insertable = true, updatable = true)
        public String getRegisterId() {
            return registerId;
        }

        public void setRegisterId(String registerId) {
            this.registerId = registerId;
        }
        @Column(name = "AUDITOR_ID", insertable = true, updatable = true)
        public String getAuditorId() {
            return auditorId;
        }

        public void setAuditorId(String auditorId) {
            this.auditorId = auditorId;
        }
        //	@Column(name = "COMPANY_NAME", insertable = true, updatable = true)
//	public String getCompanyName() {
//		return companyName;
//	}
//
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//	@Column(name = "LOGIN_CA", insertable = true, updatable = true)
//	public String getLoginCA() {
//		return loginCA;
//	}
//
//	public void setLoginCA(String loginCA) {
//		this.loginCA = loginCA;
//	}
//	@Column(name = "LOGIN_PWD", insertable = true, updatable = true)
//	public String getLoginPWD() {
//		return loginPWD;
//	}
//
//	public void setLoginPWD(String loginPWD) {
//		this.loginPWD = loginPWD;
//	}
        //@Column(name = "IMAGE_01", insertable = true, updatable = true)
        @Transient
        public String getImage01() {
            return image01;
        }

        public void setImage01(String image01) {
            this.image01 = image01;
        }
        //@Column(name = "IMAGE_02", insertable = true, updatable = true)
        @Transient
        public String getImage02() {
            return image02;
        }

        public void setImage02(String image02) {
            this.image02 = image02;
        }
        //@Column(name = "IMAGE_03", insertable = true, updatable = true)
        @Transient
        public String getImage03() {
            return image03;
        }

        public void setImage03(String image03) {
            this.image03 = image03;
        }
        //@Column(name = "IMAGE_04", insertable = true, updatable = true)
        @Transient
        public String getImage04() {
            return image04;
        }

        public void setImage04(String image04) {
            this.image04 = image04;
        }
        //@Column(name = "IMAGE_05", insertable = true, updatable = true)
        @Transient
        public String getImage05() {
            return image05;
        }

        public void setImage05(String image05) {
            this.image05 = image05;
        }


        @Column(name = "LOGIN_CA", insertable = true, updatable = true)
        public Integer getLoginCA() {
            return loginCA;
        }

        public void setLoginCA(Integer loginCA) {
            this.loginCA = loginCA;
        }

        @Column(name = "LOGIN_PWD", insertable = true, updatable = true)
        public Integer getLoginPWD() {
            return loginPWD;
        }

        public void setLoginPWD(Integer loginPWD) {
            this.loginPWD = loginPWD;
        }
}

