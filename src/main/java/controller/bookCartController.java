package controller;

import apis.BookShowApi;
import apis.CartApi;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;
import utils.Constants;
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
//        if (buid==null){
//            return "/book/index";
//        }
        Map<String,Object> map = bookShowApi.showOneBuyBook(id);
        Map<String,Object> addrMap =  cartApi.userAddrMap(buid);
        if (MapUtils.isEmpty(addrMap)){
            model.addAttribute("onebook",map);
            return "/cart/buy";
        }
        model.addAttribute("onebook",map);
        model.addAttribute("cart",addrMap);
        return "/cart/buyaddr";
    }
    @ResponseBody
    @RequestMapping("/buyit")
    public Map<String,Object> buyData(Model model){
        String buid = Utils.getBuid("BUID", request);
//        if (buid==null){
//            return Utils.msgManager(Constants.NO,"请用浏览器登陆","");
//        }
        Map<String,Object> query = WebUtils.getParametersStartingWith(request, "");
        query.put("buid", buid);
        query.put("addip", Utils.getRealIpAddr(request));
        //更新用户信息
        cartApi.userInfoHold(query);
        //更新购物车信息
        int  id = cartApi.cartInsert(query);
        if (id!=0){
            return Utils.msgManager(Constants.OK,"购物车提交成功",id);
        }else{
            return Utils.msgManager(Constants.OK,"购物车提交失败,请您重试",id);
        }
    }
    @ResponseBody
    @RequestMapping("/buyitaddr")
    public Map<String,Object> buyWithAddrExist(Model model){
        String buid = Utils.getBuid("BUID", request);
//        if (buid==null){
//            return Utils.msgManager(Constants.NO,"请用浏览器登陆","");
//        }
        Map<String,Object> query = WebUtils.getParametersStartingWith(request, "");
        query.put("buid", buid);
        query.put("addip", Utils.getRealIpAddr(request));
        //更新用户信息
        //更新购物车信息
        int  id = cartApi.cartInsert(query);
        if (id!=0){
            return Utils.msgManager(Constants.OK,"购物车提交成功",id);
        }else{
            return Utils.msgManager(Constants.OK,"购物车提交失败,请您重试",id);
        }
    }
    @RequestMapping("/pay/{id}")
    public String pay(@PathVariable int id,Model model){
        String buid = Utils.getBuid("BUID", request);
        Map<String,Object> cartMap = cartApi.getCartById(id, buid);
        model.addAttribute("cart", cartMap);
        return "/cart/pay";
    }
    @ResponseBody
    @RequestMapping("/editcart")
    public Map<String,Object> editCart(){
        String buid = Utils.getBuid("BUID", request);
        Map<String,Object> param = WebUtils.getParametersStartingWith(request, "");
        param.put("buid", buid);
        param.put("addip", Utils.getRealIpAddr(request));
        boolean updateStatus = cartApi.userInfoUpdate(param);
        if (updateStatus){
           return Utils.msgManager(Constants.OK,"修改成功","");
        }else {
           return Utils.msgManager(Constants.NO,"修改失败","");
        }
    }
    @ResponseBody
    @RequestMapping("/getCartData")
    public Map<String,Object> cartData(){
        String buid = Utils.getBuid("BUID", request);
        List<Map<String,Object>> cartList = cartApi.cartList(buid);
        return Utils.msgManager(Constants.OK,"da",cartList);
    }

    @RequestMapping("/showcart")
    public String cartList(Model model){
        return "/cart/cart";
    }


}
