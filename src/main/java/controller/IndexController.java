package controller;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.BookShowApiService;
import utils.Constants;
import utils.Utils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/8.
 */
@RestController
@RequestMapping("/book")
public class IndexController {
    @Resource
    private HttpServletRequest request;
    @Resource
    private BookShowApiService bookShowApiService;
    @RequestMapping("/index")
    public Map<String,Object> indexBookList(){
        List<Map<String,Object>> indexBook = bookShowApiService.homeShowList();
        if (CollectionUtils.isNotEmpty(indexBook)){
            return Utils.msgManager(Constants.OK,"ok",indexBook);
        }else {
            return Utils.msgManager(Constants.NO,"Sorry ,新书正在火速赶来,敬请期待!","");
        }
    }
    @RequestMapping("/classify/{id}")
    public Map<String,Object> indexClassBookList(@PathVariable int id){
        if (id<=0){
            return Utils.msgManager(Constants.NO,"您所查询的图书分类不存在","");
        }
        List<Map<String,Object>> indexClassifyBook = bookShowApiService.classifyBookList(id);
        if (CollectionUtils.isNotEmpty(indexClassifyBook)){
            return Utils.msgManager(Constants.OK,"ok",indexClassifyBook);
        }else {
            return Utils.msgManager(Constants.NO,"Sorry ,新书正在火速赶来,敬请期待!","");
        }
    }
}
