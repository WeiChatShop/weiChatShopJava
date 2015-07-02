package utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaoming on 2015/6/10.
 */
public class Utils {


    public static Map<String,Object> msgManager(String statusCode,String message,Object data){
        Map<String,Object> retMap = new HashMap<String, Object>();
        retMap.put("status",statusCode);
        retMap.put("message",message);
        retMap.put("data",data);
        return retMap;
    }
    public static int getUserId(HttpServletRequest request){
        String userId = getCookie("userId",request);
        if(!Validate.IsIntNumbers(userId)){
            return 0;
        }else {
            return Integer.parseInt(userId);
        }
    }
    public static void setCookie(String key, String value, int duration,HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie(key, URLEncoder.encode(value, "UTF-8"));
            cookie.setMaxAge(duration);
            cookie.setPath("/");
            cookie.setDomain(Constants.DOMAIN);

            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    public static String getCookie(String key,HttpServletRequest request) {
            Cookie[] cookies = request.getCookies();
            if (cookies == null || cookies.length == 0)
                return null;
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals(key))
                    return cookies[i].getValue();

            }
            return null;
    }

    public void clearCookie(HttpServletResponse response, String key){
        Cookie cookie = new Cookie(key,null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        cookie.setDomain(Constants.DOMAIN);
        response.addCookie(cookie) ;
    }



    public static String getRealIpAddr(HttpServletRequest request) {
        //just for test.
        if (request == null) {
            return "127.0.0.1";
        }
        //todo
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null) {
            int idx = ip.indexOf(",");
            if (idx > 0 && idx < ip.length()) {
                ip = (ip.substring(ip.indexOf(",") + 1)).trim();
            }
        }
        if (ip == null) {
            return "127.0.0.1";
        }
        return ip.trim();
    }

}
