package org.example;

import java.util.Objects;

public class HWexception {

    public static void hwexeption(String login, String password, String confirmPassword) {
        try {
            check(login, password, confirmPassword);
            LoopChecker(login, password, confirmPassword);
            return;
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        }

    }


    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный");
        }


        if (Objects.isNull(password) || password.length() >= 20) {
            throw new WrongPasswordException("Пароль слишком длинный");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
    }

    public static String LoopChecker(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvxywzABCDEFGHIJKLMNOPQRSTUVXYWZ123456789_";
        char[] chars = login.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!ALLOWED_CHARACTERS.contains(Character.toString(chars[i]))) {
                throw new WrongLoginException("Логин содержит некоректный символ");
            }
        }

        char[] chars1 = password.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (!ALLOWED_CHARACTERS.contains(Character.toString(chars1[i]))) {
                throw new WrongPasswordException("Пароль содержит некоректный символ");
            }
        }
        return null;
    }
}