package service;

import apis.BookShowApi;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 */
public class BookShowApiService implements BookShowApi{
    /**
     * 本周推荐图书
     *
     * @return
     */
    @Override
    public Map<String, Object> thisWeekHotBook() {
        return null;
    }

    /**
     * 图书分类显示
     *
     * @param id
     * @return
     */
    @Override
    public List<Map<String, Object>> classifyBookList(int id) {
        return null;
    }

    /**
     * 显示一本书的具体信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> showOneBook(int id) {
        return null;
    }

    /**
     * 首页显示主要是分类和具体分类地址,分类轮播图
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> homeShowList() {
        return null;
    }
}
