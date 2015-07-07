package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaoming on 2015/7/4.
 */
@Controller
public class ViewsController {

    @Resource
    private HttpServletRequest request;

    @RequestMapping("/")
    public String hello(){
        return "home/index";
    }
}
