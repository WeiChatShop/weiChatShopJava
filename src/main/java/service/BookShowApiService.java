package service;

import apis.BookShowApi;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 */
public class BookShowApiService implements BookShowApi{
    /**
     * �����Ƽ�ͼ��
     *
     * @return
     */
    @Override
    public Map<String, Object> thisWeekHotBook() {
        return null;
    }

    /**
     * ͼ�������ʾ
     *
     * @param id
     * @return
     */
    @Override
    public List<Map<String, Object>> classifyBookList(int id) {
        return null;
    }

    /**
     * ��ʾһ����ľ�����Ϣ
     *
     * @param id
     * @return
     */
    @Override
    public Map<String, Object> showOneBook(int id) {
        return null;
    }

    /**
     * ��ҳ��ʾ��Ҫ�Ƿ���;�������ַ,�����ֲ�ͼ
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> homeShowList() {
        return null;
    }
}
