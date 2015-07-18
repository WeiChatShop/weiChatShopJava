package controller;

import apis.BookShowApi;
import apis.CartApi;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.Utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/13.
 */
@Controller
public class bookCartController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private BookShowApi bookShowApi;
    @Resource
    private CartApi cartApi;
    @RequestMapping("/buynow/{id}")
    public String buyNow(@PathVariable int id,Model model){
        String buid = Utils.getBuid("BUID", request);
        Map<String,Object> map = bookShowApi.showOneBuyBook(id);
        List<Map<String,Object>> addrList =  cartApi.userAddrList(buid);
        if (addrList==null){
            cartApi.insertBuid(buid, Utils.getRealIpAddr(request));
        }
        model.addAttribute("onebook",map);
        model.addAttribute("addrList",addrList);
        return "/cart/buy";
    }
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable int id,Model model){
        String buid = Utils.getBuid("BUID", request);
        Map<String,Object> map = bookShowApi.showOneBuyBook(id);
        List<Map<String,Object>> addrList =  cartApi.userAddrList(buid);
        if (addrList==null){
            cartApi.insertBuid(buid, Utils.getRealIpAddr(request));
        }
        model.addAttribute("onebook",map);
        model.addAttribute("addrList",addrList);
        return "/cart/buy";
    }
}
