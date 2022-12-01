package com.syj.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller//标识为控制层组件

public class HelloController {
//“/” --> /WEB-INF/templates/index.html
    @RequestMapping("/")//请求映射
    public String index(){
        //返回视图名称
        return "index";
    }
    @RequestMapping("/target") //请求映射，请求和控制器方法创建关系
    public String toTarget(){
    return "target";
    }

}
