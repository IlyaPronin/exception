package org.example;

import java.util.Objects;

public class HWexception {

    public static void hwexeption(String login, String password, String confirmPassword) {
        try {
            check(login,password,confirmPassword);
            return;
        } catch (WrongPasswordException e){
            System.out.println(e.getMessage() );
        }
        catch (WrongLoginException e){
            System.out.println(e.getMessage() );
        }

    }


    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Логин слишком длинный");}

            if (Objects.isNull(password) || password.length() >= 20) {
                throw new WrongLoginException("Пароль слишком длинный");
            }
        if (! password.equals(confirmPassword)) {
            throw new WrongLoginException("Пароли должны совпадать");
        }
        }
    }


//1. Напишите статический метод, который принимает на вход три параметра: login, password и confirmPassword.
//        2. Параметр Login содержит в себе только латинские буквы, цифры и знак подчеркивания.
//        *Например, java_skypro_go*
//        1. У параметра login есть ограничение по длине – он должен быть равен или меньше 20 символов.
//        Если login длиннее 20 символов, то  необходимо выбросить исключение – `WrongLoginException`.
//        3. Параметр Password содержит в себе только латинские буквы, цифры и знак подчеркивания.
//        *Например, D_1hWiKjjP_9*
//        4. У параметра password тоже есть ограничение по длине – он должен быть строго меньше 20 символов. 
//        5. Параметры password и confirmPassword должны быть равны.
//        Если это требование не соблюдается, то нужно выбросить `WrongPasswordException`.
//        6. Для обработки исключений используйте multi-catch block.
//        7. Метод ничего не должен возвращать , если значения параметров подходят под ограничения,
//        или бросать исключение, если условия не выполняются.
//        8. При вызове метода необходимо обработать потенциальные исключения