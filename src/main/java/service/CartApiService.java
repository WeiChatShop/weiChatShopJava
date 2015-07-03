package service;

import apis.CartApi;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Service;
import utils.DateUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
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
     * 购物车列表,已加入购物车,尚未付款
     *
     * @param uid
     * @return
     */
    @Override
    public List<Map<String, Object>> cartList(String uid) {
        String sqlForCartList =
                "select bc.id,bc.uid,bc.book_id,bc.num,bc.should_pay,bi.price,bi.path,bi.name,bi.describe" +
                        " from book_cart bc left join book_info bi on bc.book_id=bi.id  where bc.uid=? and bc.payment<=0";
        List<Map<String, Object>> cartList = mysqlClient.queryForList(sqlForCartList,new Object[]{uid});
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
        String sqlForCartHisList =
                "select bc.id,bc.uid,bc.book_id,bc.num,bc.should_pay,bi.price,bi.path,bi.name,bi.describe,bc.payment" +
                        " from book_cart bc left join book_info bi on bc.book_id=bi.id  where bc.uid=? and bc.payment>0";
        List<Map<String, Object>> cartHisList = mysqlClient.queryForList(sqlForCartHisList,new Object[]{uid});
        return cartHisList;
    }

    /**
     * 收货人信息保存,同时增加收货人地址也可以用到
     * 收货人信息包括
     * @param param
     * @return
     */
    @Override
    public boolean userInfoHold(Map<String, Object> param) {
        List paramList = new ArrayList();

        paramList.add(MapUtils.getString(param,"uid",""));
        paramList.add(MapUtils.getString(param,"name",""));
        paramList.add(MapUtils.getString(param,"phone",""));
        paramList.add(MapUtils.getString(param,"province",""));
        paramList.add(MapUtils.getString(param,"city",""));
        paramList.add(MapUtils.getString(param,"detail_addr",""));
        paramList.add(MapUtils.getString(param,"addip","127.0.0.1"));
        paramList.add(DateUtils.getCurrentTimestamp());
        paramList.add(MapUtils.getString(param,"require",""));
        paramList.add(MapUtils.getString(param,"postalcode",""));
        String sqlSaveUser = "insert into `user_info`(`uid`,`name`,`phone`,`province`," +
                "`city`,`detail_addr`,`addip`,`addtime`,`require`,`postalcode`) values(?,?,?,?,?,?,?,?,?,?)";
        int s = mysqlClient.update(sqlSaveUser,paramList.toArray());
        return s!=0;
    }

    /**
     * 购物车编辑,包括删除
     *
     * @param param
     * @return
     */
    @Override
    public boolean cartEdit(Map<String, Object> param) {

        double price = bookPrice(MapUtils.getIntValue(param,"book_id",0));
        double shouldPay = price*MapUtils.getIntValue(param,"book_num",1);

        List paramList = new ArrayList();
        paramList.add(MapUtils.getIntValue(param, "book_num", 1));
        paramList.add(shouldPay);
        paramList.add(MapUtils.getString(param,"addip"));
        paramList.add(DateUtils.getCurrentTimestamp());
        paramList.add(MapUtils.getString(param,"uid"));
        paramList.add(MapUtils.getString(param, "id"));
        String sqlCartEdit =
                "update book_cart set num=?,should_pay=?,addip=?,addtime=?," +
                        "where payment<=0 and uid=? and id=?";
        int s = mysqlClient.update(sqlCartEdit,paramList.toArray());
        return s!=0;
    }

    /**
     * 选择收货人地址
     *
     * @param id
     * @return
     */
    @Override
    public boolean chooseAddr(int id,String uid) {
        String sqlSetDefAddr = "update user_info set status=0 where status=1 and uid=?";
        String sqlNewAddr = "update user_info set status=1 where id=? and uid=?";
        mysqlClient.update(sqlSetDefAddr, new Object[]{uid});
        int s = mysqlClient.update(sqlNewAddr, new Object[]{id, uid});
        return s!=0;
    }

    /**
     * 收货人地址列表
     *
     * @return
     */
    @Override
    public List<Map<String, Object>> userAddrList(String uid) {
        String sqlForAddrList = "select id,uid,name,phone,province,city,detail_addr where uid=? ";
        List<Map<String, Object>> addrList = mysqlClient.queryForList(sqlForAddrList, new Object[]{uid});
        return addrList;
    }

    /**
     * 支付,更新account_log表
     *
     * @param param
     * @return
     */
    @Override
    public boolean pay(Map<String, Object> param) {
        String sqlInsertPay = "insert into user_info(uid,pay,cart_id,paytime,payip) values(?,?,?,?,?,?)";
        boolean updateCartStatus = updateCartPayment(MapUtils.getString(param, "uid"), MapUtils.getIntValue(param, "cart_id"), MapUtils.getDoubleValue(param, "pay"));
        if (updateCartStatus) {
            mysqlClient.update(sqlInsertPay, new Object[]{
                    MapUtils.getString(param, "uid"),
                    MapUtils.getDoubleValue(param, "pay"),
                    MapUtils.getIntValue(param, "cart_id"),
                    DateUtils.getCurrentTimestamp(),
                    MapUtils.getString(param, "payip")
            });
        }
        return updateCartStatus;
    }

    /**
     * @param uid
     * @param cart_id
     */
    @Override
    public boolean updateCartPayment(String uid, int cart_id,double payment) {
        String sql = "update book_cart set payment=? where cart_id=? and uid=? and payment<=0 and should_pay<=? ";
        int s = mysqlClient.update(sql, new Object[]{payment, cart_id, uid, payment});
        return false;
    }

    public double bookPrice(int id){
        String sql = "select price from book_info where id=? and status=1";
        Map<String,Object> priceMap = mysqlClient.queryForMap(sql,new Object[]{id});
        return MapUtils.getDoubleValue(priceMap,"price",0.0);
    }

}
