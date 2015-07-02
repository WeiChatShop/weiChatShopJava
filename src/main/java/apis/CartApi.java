package apis;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 * ���ﳵAPI
 */
public interface CartApi {
    /**
     * ���ﳵ�б�
     * @param uid
     * @return
     */
    List<Map<String,Object>> cartList(String uid);
    /**
     * �����¼�б�
     * @param uid
     * @return
     */
    List<Map<String,Object>> cartHistoryList(String uid);
    /**
     * �ջ�����Ϣ����,ͬʱ�����ջ��˵�ַҲ�����õ�
     * @param param
     * @return
     */
    boolean userInfoHold(Map<String,Object> param);

    /**
     * ���ﳵ�༭,����ɾ��
     * @param param
     * @return
     */
    boolean cartEdit(Map<String,Object> param);

    /**
     * ѡ���ջ��˵�ַ
     * @param id
     * @return
     */
    boolean chooseAddr(int id);

    /**
     * �ջ��˵�ַ�б�
     * @return
     */
    List<Map<String,Object>> userAddrList();

    /**
     * ֧��,����account_log��
     * @param param
     * @return
     */
    boolean pay(Map<String,Object> param);

}
