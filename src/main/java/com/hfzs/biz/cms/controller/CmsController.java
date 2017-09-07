package com.hfzs.biz.cms.controller;

import com.hfzs.biz.cms.domain.CmsArticle;
import com.hfzs.biz.cms.service.ICmsArticleService;
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.framework.core.BaseAction;
import com.hfzs.framework.domain.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;

/**
 * Created by Administrator on 2017/8/30.
 */
@RequestMapping("/cms")
public class CmsController extends BaseAction {

    @Autowired
    private ICmsArticleService<CmsArticle> articlServic;

    @GetMapping("article/list")
    public String listView(){
        return "cms/article-list";      //返回到页
    }

    @PostMapping("article/list.json")   //产页面的json数据
    @ResponseBody
    public Page<CmsArticle> articles(@RequestBody PageDto page, HttpServletRequest request) {
        //TODO
        return null;
    }

    @DeleteMapping("article/del/${id}")
    @ResponseBody  //返回json
    public String deleteById(@PathVariable String id){
        //TODO biz

        articlServic.delete(id);

        return "success";   //error return fail str
    }


}
