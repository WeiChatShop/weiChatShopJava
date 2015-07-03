package utils;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xiaoming on 2015/7/3.
 */
public class DateUtils {
    public static Timestamp getCurrentTimestamp(){
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }
}
