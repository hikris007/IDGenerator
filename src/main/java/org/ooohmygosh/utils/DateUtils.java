package org.ooohmygosh.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String formatter(LocalDate date,String format){
        if(date == null)
            return null;

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

        return date.format(dateTimeFormatter);
    }

    public static String formatter(LocalDate date){
        return formatter(date,"yyyyMMdd");
    }
}
