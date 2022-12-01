package com.syj.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")//请求路径的初始信息（相当于父目录 /hello/testRequestmapping）
public class RequestMappingController {
//    @RequestMapping("/")
//    public String index(){
//        return "target";
//    }//多个控制器请求地址一样，就会冲突报错  There is already 'requesrtMappingController' bean method
    //要保证 @RequestMapping("")所能匹配到的请求地址是唯一的

    @RequestMapping(
            value={"/testRequestMapping","/test"},
    method = {RequestMethod.GET,RequestMethod.POST})
    //匹配浏览器发送的请求，请求路径的具体信息；value属性是一个数组，意味着请求映射可以处理多个请求；value和method一起用就是要满足两个条件
    //method默认都能匹配
    //@RequestMapping 派生注解：@GetMapping @PostMapping @PutMapping @DeleteMapping 这些注解就不用设置method属性
    //params属性 通过请求参数匹配请求,要同时满足
    public String success(){

        return "success";
    }
    @RequestMapping(value = "/testPut",method =RequestMethod.PUT)
    public String testPut(){
        return "success";
    }
    //value 404；method 405；params 400；headers 404
    @RequestMapping(
            value="/testParamsAndHeaders",
            //method = {RequestMethod.GET,RequestMethod.POST},
            params = {"username=admin","password!=123456"},//"username"必须携带；"!username"一定不能有；"username=admin"；"!username=admin"
            headers = {"Host=localhost:8080"} )//Host是键，localhost:8081是值
    public String testParamsAndHeaders(){
        return "success";
    }


    @RequestMapping(
            value="/post-request",
            //method = {RequestMethod.GET,RequestMethod.POST},
            params = {"username=admin"})//"username"必须携带；"!username"一定不能有；"username=admin"；"!username=admin"
    public String test1(){
        return "success";
    }

    @RequestMapping(value = "/testPost",method = RequestMethod.POST)
    public String testPost(){
        return "success";
    }


    /**
     * ? 表示任意单个字符
     * * 表示任意0个或多个字符
     * ** 表示任意一层或多层目录 在两个*前后添加内容是两个单独的*被解析到，要这么写 / ** /xxx/
     */
    //@RequestMapping(value = {"/a?a/testAnt"})
    @RequestMapping("/**/testAnt")
    public String testAnt(){
        return "success";
    }



}
