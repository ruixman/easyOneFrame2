package com.hfzs.biz.cms.domain;

import com.hfzs.biz.sys.domain.MyFieldAnno;
import com.hfzs.framework.domain.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="t_cms_channel")
public class CmsChannel extends BaseModel implements Serializable {

    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    @MyFieldAnno(comment = "父路径")  //comment功能暂未实现
    private String parentId;
    //树路径
    private String path;

//    @Comment("栏目名称")
    private String name;

//    @Comment("栏目类型")
    private String type;

//    @Comment("链接地址")
    private String url;

//    @Comment("打开方式")
    private String target;

//    @Comment("是否显示")
    private boolean showAble;

//    @Comment("是否禁用")
    private boolean disabled;

//    @Comment("排序字段")
    private Integer location;

//    @Comment("有子节点")
    private boolean hasChildren;

    @OneToMany(targetEntity = CmsArticle.class, mappedBy = "channel",fetch = FetchType.LAZY)
    private Set<CmsArticle> articleItem;

    public Set<CmsArticle> getArticleItem() {
        return articleItem;
    }

    public void setArticleItem(Set<CmsArticle> articleItem) {
        this.articleItem = articleItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public boolean isShowAble() {
        return showAble;
    }

    public void setShowAble(boolean showAble) {
        this.showAble = showAble;
    }
}
