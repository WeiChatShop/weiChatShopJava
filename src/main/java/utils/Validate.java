package utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaoming on 2015/6/7.
 */
public class Validate {
    /**
     * @param regex 正则表达式字符串
     * @param str   要匹配的字符串
     * @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    /**
     * 是否是md5的密码
     * @param str
     * @return
     */
    public static boolean isPassword(String str) {
        String regex = "^[0-9A-Fa-f]{32}$";
        return match(regex, str);
    }

    /**
     * 验证的正整数
     *
     * @param str 待验证的字符串
     * @return 如果是符合格式的字符串, 返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean IsIntNumbers(String str) {
        String regex = "^//d*[1-9]//d*$";
        return match(regex, str);
    }
    /**
     * 手机号码验证
     * @author zhaomingwei
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        String regex = "^1[34578][0-9]{9}$";
        return match(regex,phone);
    }

    /**
     * 验证用户名的格式和长度
     * @author zhaomingwei
     *
     */
    public static boolean validateUsername(String username){
        String validateStr = "^[\\w\\-－＿\\d\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A]+$";
        boolean rs = false;
        rs = match(validateStr, username);
        //判断是否全为数字
        boolean isnum = false;
        String validateNum = "^[\\d]+$";
        isnum=match(validateNum,username);
        if (isnum){
            rs=false;
        }
        if (rs) {
            int strLenth = 0;
            try {
                strLenth = username.getBytes("gbk").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (strLenth < 4 || strLenth > 20) {
                rs = false;
            }

        }
        return rs;
    }

    /**
     * 验证邮箱
     *
     * @param str 待验证的字符串
     * @return 如果是符合的字符串, 返回 <b>true </b>,否则为 <b>false </b>
     */
    public static boolean isEmail(String str) {
        String regex = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
        return match(regex, str);
    }

}
