package RozetkaTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomData.*;

class RegistrationRozetkaTests {

    String url = "https://rozetka.com.ua/";
    String email = "testmail@test.qa";
    String username = "Тестовый Тест";

    @Test
    void registrationTest() {
        
        open(url);
        
        $(".header-topline__user-link").click(); //Кликаем на форму входа
        $(".auth-modal__register-link").click(); //Переходим на форму регистрации
        $(by("formcontrolname", "name")).setValue(username); //Вводим имя
        $(by("formcontrolname", "username")).setValue(getRandomEmail()); //Вводим почту
        $(by("formcontrolname", "password")).setValue(getRandomString(10)); //Вводим пароль
        $(by("type", "submit")).click(); //Нажимаем "Зарегистрироваться"

        $(".header-topline__user-link")
                .shouldHave(text(username));
    }

    @Test
    void userExistsRegistrationTest() {

        open(url);

        $(".header-topline__user-link").click(); //Кликаем на форму входа
        $(".auth-modal__register-link").click(); //Переходим на форму регистрации
        $(by("formcontrolname", "name")).setValue(username); //Вводим имя
        $(by("formcontrolname", "username")).setValue(email); //Вводим почту
        $(by("formcontrolname", "password")).setValue(getRandomString(10)); //Вводим пароль
        $(by("type", "submit")).click(); //Нажимаем "Зарегистрироваться"

        $(".js-contact")
                .shouldHave(text("Пользователь с логином "+email+" уже зарегистрирован"));
    }

}


