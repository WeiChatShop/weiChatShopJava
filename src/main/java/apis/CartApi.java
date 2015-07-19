package apis;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by xiaoming on 2015/7/2.
 * 购物车API
 */
@Repository
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
    int userInfoHold(Map<String,Object> param);

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
    boolean chooseAddr(int id,String uid);

    boolean getValidAddr(String uid);
    /**
     * 收货人地址列表
     * @return
     */
    Map<String,Object> userAddrMap(String uid);

    Map<String,Object> getCartById(int id,String buid);



    /**
     * 支付,更新account_log表
     * @param param
     * @return
     */
    boolean pay(Map<String,Object> param);

    /**
     *更新购物车支付信息
     */
    boolean updateCartPayment(String uid,int cart_id,double payment);
    /**
     * 插入购买商品
      */
    int cartInsert(Map<String,Object> param);

    /**
     * 插入buid
     * @param buid
     * @param ip
     * @return
     */
    boolean insertBuid(String buid,String ip);

    /**
     * 修改地址
     * @param param
     * @return
     */
    boolean userInfoUpdate(Map<String,Object> param);
}
