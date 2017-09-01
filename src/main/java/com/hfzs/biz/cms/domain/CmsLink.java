package com.hfzs.biz.cms.domain;

import com.hfzs.framework.domain.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/1.
 */
@Entity
@Table(name = "t_cms_link")
public class CmsLink extends BaseModel {

    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private String name;      //名称

    private String picurl;    //图片的位置，保存相对路径

    private String url;       //链接的url

    @Column(columnDefinition = "enum('_blank','_self')")
    private String target;   //链接打开的方式，_blank:新页面，_self:在本页面内打开

    private int seqs;        //排序号，越小越靠前，最小为0

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getSeqs() {
        return seqs;
    }

    public void setSeqs(int seqs) {
        this.seqs = seqs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

}
