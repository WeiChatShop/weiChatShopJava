package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaoming on 2015/7/13.
 */
@Controller
public class bookCartController {
    @Resource
    private HttpServletRequest request;
    @RequestMapping("/buynow")
    public String buyNow(){
        return null;
    }
}
