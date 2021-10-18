package com.github.blog.usecase.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PASSWORD_PATTERN =
        "/^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[$*&@#])[0-9a-zA-Z$*&@#]{8,}$/";

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

    public static boolean ValidationPassword(String password) {
        if(password != null && !password.isEmpty()) {
            Pattern pattern = Pattern.compile(PASSWORD_PATTERN, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(password);

            return matcher.matches();
        }
        return false;
    }

}
