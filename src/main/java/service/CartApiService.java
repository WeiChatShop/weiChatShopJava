package service;

import apis.CartApi;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 */
public class CartApiService implements CartApi {
    /**
     * ���ﳵ�б�
     *
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> cartList(String uid) {
        return null;
    }

    /**
     * �����¼�б�
     *
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> cartHistoryList(String uid) {
        return null;
    }

    /**
     * �ջ�����Ϣ����,ͬʱ�����ջ��˵�ַҲ�����õ�
     *
     * @param param
     * @return
     */
    @Override
    public boolean userInfoHold(Map<String, Object> param) {
        return false;
    }

    /**
     * ���ﳵ�༭,����ɾ��
     *
     * @param param
     * @return
     */
    @Override
    public boolean cartEdit(Map<String, Object> param) {
        return false;
    }

    /**
     * ѡ���ջ��˵�ַ
     *
     * @param id
     * @return
     */
    @Override
    public boolean chooseAddr(int id) {
        return false;
    }

    /**
     * �ջ��˵�ַ�б�
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> userAddrList() {
        return null;
    }

    /**
     * ֧��,����account_log��
     *
     * @param param
     * @return
     */
    @Override
    public boolean pay(Map<String, Object> param) {
        return false;
    }
}
