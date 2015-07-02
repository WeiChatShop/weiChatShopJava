package apis;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 * ҳ��չʾ������API
 */
public interface BookShowApi {
    /**
     * �����Ƽ�ͼ��
     * @return
     */
    Map<String,Object> thisWeekHotBook();

    /**
     * ͼ�������ʾ
     * @param id
     * @return
     */
    List<Map<String,Object>> classifyBookList(int id);

    /**
     * ��ʾһ����ľ�����Ϣ
     * @param id
     * @return
     */
    Map<String,Object> showOneBook(int id);

    /**
     * ��ҳ��ʾ��Ҫ�Ƿ���;�������ַ,�����ֲ�ͼ
     * @return
     */
    List<Map<String,Object>> homeShowList();
}
