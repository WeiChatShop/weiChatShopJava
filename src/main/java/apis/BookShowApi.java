package apis;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 * 页面展示的数据API
 */
@Repository
public interface BookShowApi {
    /**
     * 本周推荐图书
     * @return
     */
    Map<String,Object> thisWeekHotBook();

    /**
     * 图书分类显示
     * @param id
     * @return
     */
    List<Map<String,Object>> classifyBookList(int id);

    /**
     * 显示一本书的具体信息
     * @param id
     * @return
     */
    Map<String,Object> showOneBook(int id);
    /**
     * 显示一本书的具体信息
     * @param id
     * @return
     */
    Map<String,Object> showOneBuyBook(int id);

    /**
     * 首页显示主要是分类和具体分类地址,分类轮播图
     * @return
     */
    List<Map<String,Object>> homeShowList();

    /**
     *
     * @param id
     * @return
     */
    Map<String,Object> showBuyIt(int id);
}
