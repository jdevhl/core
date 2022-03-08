package com.github.jdevhl.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EasyEmail {

    private static final String EMAIL_VALID_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    public static boolean isValid(String email) {
        final Pattern pattern = Pattern.compile(EMAIL_VALID_PATTERN, Pattern.CASE_INSENSITIVE);
        final Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
