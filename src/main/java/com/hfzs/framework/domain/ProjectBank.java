package com.hfzs.framework.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by wei on 2017/3/20.
 * 项目账号信息
 */
@Entity
@Table(name = "t_project_bank")
public class ProjectBank implements Serializable{
	@Id
	@GeneratedValue(generator = "UIDGenerator")
	@GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    @Column(name = "PROJECTID")
    private String projectId;//项目id

    @Column(name = "PROJECTNO")
    private String projectNo;//项目编号

    @Column(name = "IACCTNO")
    private String acctNo;//虚拟子账号

	@Column(name = "AUTHCODE")
    private String authCode;//授权码
    
    @Column(name = "CREATETIME")//创建时间
    private Date createTime=new Date();


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(String projectNo) {
        this.projectNo = projectNo;
    }

    public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	
	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	@Override
	public String toString() {
		return "ProjectBank [id=" + id + ", projectId=" + projectId
				+ ", projectNo=" + projectNo + ", iAcctNo=" + acctNo
				+ ", authCode=" + authCode + ", createTime=" + createTime + "]";
	}
	
	
}
