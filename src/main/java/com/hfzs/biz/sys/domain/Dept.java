package com.hfzs.biz.sys.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description 机构对应的实体类
 * @author fengya
 * @date 2015-7-31 上午10:45:54
 */
@Entity
@Table(name = "T_SYS_DEPT_INFO")
@SuppressWarnings("serial")
public class Dept implements Serializable {
	private String id;
	private String name;
	private String pid;
	private String pName;
	private String type;
	private String pUnit;
	private String pUnitName;
	private Integer flag = 0;
	private Date createTime;
	private Date updateTime;
	private String createrId;
	private String updaterId;
	private String createrName;
	private String updaterName;
	private String deptCode;//DEPT_CODE;
	private Integer doubleAuditable; //是否双审核
	

	@Column(name = "double_auditable", nullable = false)
	public Integer getDoubleAuditable() {
		return doubleAuditable;
	}

	public void setDoubleAuditable(Integer doubleAuditable) {
		this.doubleAuditable = doubleAuditable;
	}

	@Transient
	public String getpUnitName() {
		return pUnitName;
	}

	public void setpUnitName(String pUnitName) {
		this.pUnitName = pUnitName;
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

	@Column(name = "P_ID", insertable = true, updatable = true)
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "P_UNIT", insertable = true, updatable = true)
	public String getpUnit() {
		return pUnit;
	}

	public void setpUnit(String pUnit) {
		this.pUnit = pUnit;
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

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Transient
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	@Column(name = "DEPT_CODE", insertable = true, updatable = true)
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}
}
