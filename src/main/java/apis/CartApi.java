package apis;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 * 购物车API
 */
public interface CartApi {
    /**
     * 购物车列表
     * @param uid
     * @return
     */
    List<Map<String,Object>> cartList(String uid);
    /**
     * 购物记录列表
     * @param uid
     * @return
     */
    List<Map<String,Object>> cartHistoryList(String uid);
    /**
     * 收货人信息保存,同时增加收货人地址也可以用到
     * @param param
     * @return
     */
    boolean userInfoHold(Map<String,Object> param);

    /**
     * 购物车编辑,包括删除
     * @param param
     * @return
     */
    boolean cartEdit(Map<String,Object> param);

    /**
     * 选择收货人地址
     * @param id
     * @return
     */
    boolean chooseAddr(int id);

    /**
     * 收货人地址列表
     * @return
     */
    List<Map<String,Object>> userAddrList();

    /**
     * 支付,更新account_log表
     * @param param
     * @return
     */
    boolean pay(Map<String,Object> param);

}
