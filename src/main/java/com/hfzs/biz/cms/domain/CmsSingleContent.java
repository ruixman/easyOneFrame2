package com.hfzs.biz.cms.domain;

import com.hfzs.framework.domain.BaseModel;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;

/**单个内容页面
 * Created by Administrator on 2017/8/31.
 */
@Entity
@Table(name = "t_cms_single_content")
public class CmsSingleContent extends BaseModel{
    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    @Column(unique = true)          //不可相同
    private String contentType;     //类型,如了解智圣-》目的意义

    @Lob
    private String content;         //文章内容

    private String title;           //标题

    @ManyToOne
    @JoinColumn(name = "class_id")  //类别id
    private CmsChannel cmsChannel;

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
