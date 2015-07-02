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
     * 购物车列表
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
     * 购物记录列表
     *
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> cartHistoryList(String uid) {
        return null;
    }

    /**
     * 收货人信息保存,同时增加收货人地址也可以用到
     *
     * @param param
     * @return
     */
    @Override
    public boolean userInfoHold(Map<String, Object> param) {
        return false;
    }

    /**
     * 购物车编辑,包括删除
     *
     * @param param
     * @return
     */
    @Override
    public boolean cartEdit(Map<String, Object> param) {
        return false;
    }

    /**
     * 选择收货人地址
     *
     * @param id
     * @return
     */
    @Override
    public boolean chooseAddr(int id) {
        return false;
    }

    /**
     * 收货人地址列表
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> userAddrList() {
        return null;
    }

    /**
     * 支付,更新account_log表
     *
     * @param param
     * @return
     */
    @Override
    public boolean pay(Map<String, Object> param) {
        return false;
    }
}
