package utils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaoming on 2015/6/7.
 */
public class Validate {
    /**
     * @param regex ������ʽ�ַ���
     * @param str   Ҫƥ����ַ���
     * @return ���str ���� regex��������ʽ��ʽ,����true, ���򷵻� false;
     */
    private static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    /**
     * �Ƿ���md5������
     * @param str
     * @return
     */
    public static boolean isPassword(String str) {
        String regex = "^[0-9A-Fa-f]{32}$";
        return match(regex, str);
    }

    /**
     * ��֤��������
     *
     * @param str ����֤���ַ���
     * @return ����Ƿ��ϸ�ʽ���ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean IsIntNumbers(String str) {
        String regex = "^//d*[1-9]//d*$";
        return match(regex, str);
    }
    /**
     * �ֻ�������֤
     * @author zhaomingwei
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        String regex = "^1[34578][0-9]{9}$";
        return match(regex,phone);
    }

    /**
     * ��֤�û����ĸ�ʽ�ͳ���
     * @author zhaomingwei
     *
     */
    public static boolean validateUsername(String username){
        String validateStr = "^[\\w\\-����\\d\u4e00-\u9fa5\uFF21-\uFF3A\uFF41-\uFF5A]+$";
        boolean rs = false;
        rs = match(validateStr, username);
        //�ж��Ƿ�ȫΪ����
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
     * ��֤����
     *
     * @param str ����֤���ַ���
     * @return ����Ƿ��ϵ��ַ���, ���� <b>true </b>,����Ϊ <b>false </b>
     */
    public static boolean isEmail(String str) {
        String regex = "^([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\\_|\\.]?)*[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
        return match(regex, str);
    }

}
