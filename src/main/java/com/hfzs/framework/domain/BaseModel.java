package com.hfzs.framework.domain;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

/**
 * Created by Administrator on 2017/8/30.
 */
//@Entity
@MappedSuperclass
public class BaseModel {

    private String opName;

    private String createTime;

    private String updateTime;

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
