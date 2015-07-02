package utils;

import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xiaoming on 2015/6/7.
 */
public class HttpUtils {
    public static String getParam(HttpServletRequest req, String paramName, String def) {
        String ret = req.getParameter(paramName);
        if (StringUtils.isEmpty(ret)) {
            ret = def;
        }
        return ret;
    }

    public static Date getParamAsDate(HttpServletRequest req, String paramName, SimpleDateFormat sdf, Date def) {
        try {
            return sdf.parse(req.getParameter(paramName).trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static float getParamAsFloat(HttpServletRequest req, String paramName, float def) {
        try {
            return Float.parseFloat(req.getParameter(paramName).trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static double getParamAsDouble(HttpServletRequest req, String paramName, double def) {
        try {
            return Double.parseDouble(req.getParameter(paramName).trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static Integer getParamAsInteger(HttpServletRequest req, String paramName, Integer def) {
        try {
            return Integer.parseInt(req.getParameter(paramName).trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static int getParamAsInt(HttpServletRequest req, String paramName, int def) {
        try {
            return Integer.parseInt(req.getParameter(paramName).trim());
        } catch (Exception e) {
            return def;
        }
    }

    public static long getParamAsLong(HttpServletRequest req, String paramName, long def) {
        try {
            return Long.parseLong(req.getParameter(paramName).trim());
        } catch (Exception e) {
            return def;
        }
    }

}
