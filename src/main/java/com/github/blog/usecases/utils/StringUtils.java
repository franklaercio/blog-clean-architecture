package com.github.blog.usecases.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static boolean ValidationLength(String text) {
        return text.length() >= 3;
    }

    public static boolean ValidationEmail(String email) {
        if(email != null && !email.isEmpty()) {
            Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);

            return matcher.matches();
        }

        return false;
    }

}
