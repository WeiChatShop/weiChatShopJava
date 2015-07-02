package service;

import apis.CartApi;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 */
public class CartApiService implements CartApi {
    /**
     * 购物车列表
     *
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> cartList(String uid) {
        return null;
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
