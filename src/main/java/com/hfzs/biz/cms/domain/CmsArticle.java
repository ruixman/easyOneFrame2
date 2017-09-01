package com.hfzs.biz.cms.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Wizzer on 2016/7/18.
 */
@Entity
@Table(name="t_cms_article")
public class CmsArticle implements Serializable {

    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private String title;
    private String info;           //文章简介
    private String author;         //文章作者
    private String picurl;            //标题图片

    @Lob
    private String content;           //文章内容
    private boolean disabled;         //是否禁用
    private Integer publishAt;        //发布时间,记录为时间戳
    private Integer location;         //排序字段,序号越小越靠前
    private boolean recommandAble=false;   //是否推荐

    @ManyToOne(fetch=FetchType.EAGER)    //立即加载
    @JoinColumn(name="channel_id")
    private CmsChannel channel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Integer publishAt) {
        this.publishAt = publishAt;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public CmsChannel getChannel() {
        return channel;
    }

    public void setChannel(CmsChannel channel) {
        this.channel = channel;
    }

    public boolean isRecommandAble() {
        return recommandAble;
    }

    public void setRecommandAble(boolean recommandAble) {
        this.recommandAble = recommandAble;
    }
}
