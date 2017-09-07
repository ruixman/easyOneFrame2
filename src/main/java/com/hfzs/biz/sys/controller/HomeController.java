package com.hfzs.biz.sys.controller;

import com.hfzs.biz.cms.domain.CmsArticle;
import com.hfzs.biz.cms.domain.CmsChannel;
import com.hfzs.biz.cms.repository.CmsChannelDao;
import com.hfzs.biz.cms.service.impl.CmsArticleServiceImpl;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/21.
 */
@Controller
public class HomeController {

    @Autowired
    private CmsArticleServiceImpl cmsArticleService;

    @Autowired
    private CmsChannelDao channelDao;

    @RequestMapping(value = {"/","/index.htm","/index.html","/index"})
    public ModelAndView index(){

//        CmsArticle article= cmsArticleService.getOne("402884825e311d8d015e311da4cc0001");
//
//        String title = article.getTitle();
//        CmsChannel channel = article.getChannel();
//        System.out.print(channel.getName());
//
//        CmsChannel channel1=channelDao.findOne("402884825e311d8d015e311da48c0000");
//        Set<CmsArticle> as=channel1.getArticleItem();
//
//        for(CmsArticle a:as){
//            System.out.print("标题是："+a.getTitle());
//        }

        return  new ModelAndView("index");
    }

    @GetMapping (value = "/login")
    public String login(){
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(HttpServletRequest request, Map<String, Object> map){
        System.out.println("HomeController.login()");
        // 登录失败从request中获取shiro处理的异常信息。
        // shiroLoginFailure:就是shiro异常类的全类名.
        String exception = (String) request.getAttribute("shiroLoginFailure");

        System.out.println("exception=" + exception);
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> "+exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("errMsg", msg);
        // 此方法不处理登录成功,由shiro进行处理.
        return "login";
    }


}
