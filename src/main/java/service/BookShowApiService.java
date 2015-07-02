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
     * �����Ƽ�ͼ��
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
     * ͼ�������ʾ,��������б�
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
     * ��ʾһ����ľ�����Ϣ
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
     * ��ҳ��ʾ��Ҫ�Ƿ���;�������ַ,�����ֲ�ͼ
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
