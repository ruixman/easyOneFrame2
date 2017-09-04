package com.hfzs.biz.cms.domain;

import com.hfzs.framework.domain.BaseModel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4.
 */
@Entity
@Table(name = "t_product_class")      //商品类别表
public class ProductClass extends BaseModel{

    @Id
    @GeneratedValue(generator = "UIDGenerator")
    @GenericGenerator(name = "UIDGenerator", strategy = "org.hibernate.id.UUIDHexGenerator")
    private String id;

    private String className;       //类别名称

    private String classCode;      //类别代码

    //下属的商品
    @OneToMany(targetEntity = Product.class,mappedBy = "productClass",fetch = FetchType.LAZY)
    private List<Product> productList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
