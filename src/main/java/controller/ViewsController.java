package controller;

import apis.BookShowApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.Constants;
import utils.Utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public String index(){
        return "home/index";
    }
    @RequestMapping("/classify")
    public String indexClassify(){
        return "home/classify";
    }

    @RequestMapping("/one/{id}")
    public String indexOne(Model model, @PathVariable int id) {
        if(id<=0){
            Utils.msgManager(Constants.NO,"Sorry 您所找的图书不存在,敬请期待!","");
        }
        Map<String, Object> oneBook =  bookShowApi.showOneBook(id);
        model.addAttribute("oneBook",oneBook);
        return "home/oneBook";
    }
}
