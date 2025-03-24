package com.sprint.mvc.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VaildationRegex {

    public static boolean isValidUserId(String userId) {
        String regex = "^[a-zA-Z0-9]{6,30}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(userId);
        return matcher.matches();
    }

    public static boolean isVaildPassword(String password) {
        String regex = "^(?=(.*[a-zA-Z]){2,})(?=(.*\\d){2,})(?=(.*[!@#$%^&*]){2,})[a-zA-Z\\d!@#$%^&*]{12,50}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9._%+-]{1,100}@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidNickname(String Nickname) {
        String regex = "^[\\x20-\\x7E\\xA0-\\xFF\\u0400-\\u04FF\\u4E00-\\u9FFF]{1,50}$";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(Nickname);
        return matcher.matches();
    }
}
