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

//文章简介
    private String info;
    private String author;   //文章简介
    private String picurl;    //标题图
    private String content;   //文章内容
    private boolean disabled;    //是否禁用
    private Integer publishAt;  //发布时间
    private Integer location;   //排序字段
//    private String channelId;   //类别ID:manyToOne双向

    @ManyToOne(fetch=FetchType.EAGER)    //延迟加载，提高性能
//    @JoinTable(name = "t_cms_channel"
//            ,
//            joinColumns = @JoinColumn(
//                    name = "channelId",
//                    insertable = false,
//                    updatable = false)
//    )
    @JoinColumn(name="channel_id")
    private CmsChannel channel;

//    public String getChannelId() {
//        return channelId;
//    }
//
//    public void setChannelId(String channelId) {
//        this.channelId = channelId;
//    }

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
}
