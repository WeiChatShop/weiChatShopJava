package service;

import apis.CartApi;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 */
@Service("cartApiService")
public class CartApiService implements CartApi {
    @Resource
    private MysqlClient mysqlClient;
    /**
     * ���ﳵ�б�
     *
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> cartList(String uid) {
        String sqlForCartList =
                "select bc.id,bc.uid,bc.book_id,bc.num,bc.should_pay,bi.price,bi.path,bi.name,bi.describe" +
                " from book_cart bc left join book_info bi on bc.book_id=bi.id  where bc.uid=? and bc.payment<=0";
        List<Map<String, Object>> cartList = mysqlClient.queryList(sqlForCartList,new Object[]{uid});
        return cartList;
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
