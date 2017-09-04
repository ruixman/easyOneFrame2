package com.hfzs.biz.cms.domain;

import com.hfzs.framework.domain.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/4.
 */
@Entity
@Table(name = "t_product_info")     //商品信息表
public class Product extends BaseModel {

    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private String productName;           //产品名称

    private Date releaseTime;             //发布时间

    private String author;                //作者

    @Lob
    private String content;               //文章内容

    @ManyToOne
    @JoinColumn(name="class_id")
    private ProductClass productClass;    //产品类别


}