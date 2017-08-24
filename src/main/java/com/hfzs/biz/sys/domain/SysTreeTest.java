package com.hfzs.biz.sys.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/23.
 */
@Entity
@Table(name = "T_SYS_TREE_TEST")

public class SysTreeTest {

    private String id;

    //父节点ID 默认
    private String parent = "#";

    //节点名称
    private String text;

    //节点图标
    private String icon;

    //节点属性
    private TreeState state;

    private String li_attr;

    private String a_attr;

    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "PARENT", insertable = true, updatable = true)
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Column(name = "TEXT", insertable = true, updatable = true)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Column(name = "ICON", insertable = true, updatable = true)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

//    @Column(name = "STATE", insertable = true, updatable = true)
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }

    @Transient
    public TreeState getState() {
        if (state == null) {
            state = new TreeState();
        }
        return state;
    }

    public void setState(TreeState state) {
        this.state = state;
    }

    @Column(name = "LI_ATTR", insertable = true, updatable = true)
    public String getLi_attr() {
        return li_attr;
    }

    public void setLi_attr(String li_attr) {
        this.li_attr = li_attr;
    }

    @Column(name = "A_ATTR", insertable = true, updatable = true)
    public String getA_attr() {
        return a_attr;
    }

    public void setA_attr(String a_attr) {
        this.a_attr = a_attr;
    }
}
