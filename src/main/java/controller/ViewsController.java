package controller;

import apis.BookShowApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by xiaoming on 2015/7/4.
 */
@Controller
public class ViewsController {

    @Resource
    private BookShowApi bookShowApi;
    @Resource
    private HttpServletRequest request;

    @RequestMapping("/")
    public String index(Model model){
        return "home/index";
    }
}
