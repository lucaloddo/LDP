package it.unimib.easydefence.utils;

import it.unimib.easydefence.exception.DateConvertionException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private DateUtils() {

    }

    public static String convertDate(String dateToConvert, String originalPattern, String newPattern) {
        if (dateToConvert == null || originalPattern == null || newPattern == null) {
            return null;
        }
        SimpleDateFormat originalFormat = new SimpleDateFormat(originalPattern);
        Date date = null;

        try {
            date = originalFormat.parse(dateToConvert);
        } catch (ParseException e) {
            throw new DateConvertionException(e.getMessage());
        }

        SimpleDateFormat outputFormat = new SimpleDateFormat(newPattern);

        return outputFormat.format(date);
    }

}
