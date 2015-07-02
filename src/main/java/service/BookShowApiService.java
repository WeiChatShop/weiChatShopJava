package service;

import apis.BookShowApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 */
@Service("bookShowApiService")
public class BookShowApiService implements BookShowApi{
    @Resource
    private MysqlClient mysqlClient;
    /**
     * 本周推荐图书
     *
     * @return
     */
    @Override
    public Map<String, Object> thisWeekHotBook() {
        String sqlForHotBook = "SELECT `id`, `name`,`describe`,`list`, `path`, `stock`, " +
                " `sell`, `hot`, `classify_id`,(select name from book_class bc where bi.classify_id=bc.id ), `price`, `freight`  FROM `book_info` bi" +
                " where status=1 and hot=1 limit 0,1";
        Map<String,Object> hotBookInfo = mysqlClient.queryForMap(sqlForHotBook,null);
        return hotBookInfo;
    }

    /**
     * 图书分类显示,各个类的列表
     *
     * @param id
     * @return
     */
    @Override
    public List<Map<String, Object>> classifyBookList(int id) {
        String sqlForBookList =
                "select `id`, `name`,`describe` ,path,hot, `classify_id`," +
                "(select name from book_class bc where bi.classify_id=bc.id ) classify_name," +
                " `price`, `freight`  from `book_info` bi where status=1 and classify_id=?";
        List<Map<String, Object>> bookList = mysqlClient.queryList(sqlForBookList,new Object[]{id});
        return bookList;
    }

    /**
     * 显示一本书的具体信息
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> showOneBook(int id) {
        String sqlForOneBook = "SELECT `id`, `name`,`describe`,`list`, `path`, `stock`, " +
                " `sell`, `hot`, `classify_id`,(select name from book_class bc where bi.classify_id=bc.id ), `price`, `freight`  FROM `book_info` bi" +
                " where status=1 limit 0,1";
        Map<String,Object> oneBookInfo = mysqlClient.queryForMap(sqlForOneBook,new Object[]{id});
        return oneBookInfo;
    }

    /**
     * 首页显示主要是分类和具体分类地址,分类轮播图
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> homeShowList() {
        String sqlForHomeShowList =
                "select `id`, `name`,`describe` ,path,hot, `classify_id`, " +
                "(select name from book_class bc where bi.classify_id=bc.id ) classify_name, " +
                "`price`, `freight`  from `book_info` bi where status=1";
        return null;
    }
}
