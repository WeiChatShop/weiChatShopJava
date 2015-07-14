package controller;

import apis.BookShowApi;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Resource
    private BookShowApi bookShowApi;
    @RequestMapping("/buynow/{id}")
    public String buyNow(@PathVariable int id){
        bookShowApi.showOneBook(id);
        return null;
    }
}
