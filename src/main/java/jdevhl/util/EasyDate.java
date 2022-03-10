package jdevhl.util;

import jdevhl.lang.EasyString;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Utility class for use of Dates.
 *
 * @author Oscar Montes
 * @see java.util.Date
 * @since 1.0.0
 */
public class EasyDate {

    public static final String HYPHEN_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String HYPHEN_DD_MM_YYYY = "dd-MM-yyyy";
    public static final String SLASH_DD_MM_YYYY = "dd/MM/yyyy";

    /**
     * Transform String to Date with format and locale
     *
     * @param value
     * @param format
     * @param locale
     * @return
     * @throws ParseException
     */
    public static Date fromString(String value, String format, Locale locale) throws ParseException {
        Date date = null;
        if (EasyString.isNotEmpty(value)) {
            SimpleDateFormat formatter = null;
            if (locale != null) {
                formatter = new SimpleDateFormat(format, locale);
            } else {
                formatter = new SimpleDateFormat(format);
            }
            date = formatter.parse(value);
        }
        return date;
    }

    /**
     * Transform String to Date with format
     *
     * @param value
     * @param format
     * @return
     * @throws ParseException
     */
    public static Date fromString(String value, String format) throws ParseException {
        return fromString(value, format, null);
    }

    /**
     * Transform String to Date
     *
     * @param value
     * @return
     * @throws ParseException
     */
    public static Date fromString(String value) throws ParseException {
        String format = determineDateFormat(value);
        if (format == null) {
            throw new IllegalArgumentException("Date Format nos supported to value " + value);
        }
        return fromString(value, format);
    }

    private static String determineDateFormat(String dateString) {
        for (String regexp : DATE_FORMAT_REGEXPS.keySet()) {
            if (dateString.matches(regexp) || dateString.toLowerCase().matches(regexp)) {
                return DATE_FORMAT_REGEXPS.get(regexp);
            }
        }
        return null;
    }

    private static final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>() {
        {
            put("^\\d{8}$", "yyyyMMdd");
            put("^\\d{12}$", "yyyyMMddHHmm");
            put("^\\d{8}\\s\\d{4}$", "yyyyMMdd HHmm");
            put("^\\d{14}$", "yyyyMMddHHmmss");
            put("^\\d{8}\\s\\d{6}$", "yyyyMMdd HHmmss");
            put("^\\d{1,2}-\\d{1,2}-\\d{4}$", "dd-MM-yyyy");
            put("^\\d{1,2}/\\d{1,2}/\\d{4}$", "dd/MM/yyyy");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}$", "yyyy-MM-dd");
            put("^\\d{4}/\\d{1,2}/\\d{1,2}$", "yyyy/MM/dd");
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", "dd MMM yyyy");
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", "dd MMMM yyyy");
            put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}$", "dd-MM-yyyy HH:mm");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}$", "yyyy-MM-dd HH:mm");
            put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}$", "MM/dd/yyyy HH:mm");
            put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}$", "yyyy/MM/dd HH:mm");
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", "dd MMM yyyy HH:mm");
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", "dd MMMM yyyy HH:mm");
            put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd-MM-yyyy HH:mm:ss");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", "yyyy-MM-dd HH:mm:ss");
            put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "MM/dd/yyyy HH:mm:ss");
            put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", "yyyy/MM/dd HH:mm:ss");
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd MMM yyyy HH:mm:ss");
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", "dd MMMM yyyy HH:mm:ss");
            put("^\\d{4}-\\d{1,2}-\\d{1,2}T\\d{1,2}:\\d{2}:\\d{2}\\.\\d{2}[-+]\\d{2}:\\d{2}$", "yyyy-MM-dd'T'HH:mm:ss.SSS");
        }
    };
}
