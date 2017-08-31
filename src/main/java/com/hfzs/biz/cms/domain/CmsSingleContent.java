package com.hfzs.biz.cms.domain;

import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;

/**单个内容页面
 * Created by Administrator on 2017/8/31.
 */
@Entity
@Table(name = "t_cms_single_content")
public class CmsSingleContent {
    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    @Column(unique = true)          //不可相同
    private String contentType;     //文章类型

    @Column(length = 4000)
    private String content;

    private String title;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    private String createName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
