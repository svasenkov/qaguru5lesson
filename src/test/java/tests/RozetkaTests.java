package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomData.*;

class RegistrationRozetkaTests {
    String url = "https://rozetka.com.ua/";
    String username = "Тестовый Тест";

    @Test
    void registrationTest() {
        //Открываем сайт
        open(url);
        //Кликаем на форму входа
        $(".header-topline__user-link").click();
        //Переходим на форму регистрации
        $(".auth-modal__register-link").click();
        //Вводим имя
        $(by("formcontrolname", "name")).setValue(username);
        //Вводим почту
        $(by("formcontrolname", "username")).setValue(getRandomEmail());
        //Вводим пароль
        $(by("formcontrolname", "password")).setValue(getRandomString(10));
        //Нажимаем "Зарегистрироваться"
        $(by("type", "submit")).click();
        //Проверяем что имя которое мы ввели при регистрации совпадает с тем что появилось. Если совпадает - считаем тест успешным
        $(".header-topline__user-link").shouldHave(text(username));
    }

}

class LoginRozetkaTests {

    String url = "https://rozetka.com.ua/";
    String email = "testmail@test.qa";
    String pass = "Qwerty321";
    String username = "Тестовый Тест";

    @Test
    void successfullLoginTest() {
        //Открываем сайт
        open(url);
        //Нажимаем кнопку входа
        $(".header-topline__user-link").click();
        //Вводим почту
        $("#auth_email").setValue(email);
        //Вводим пароль
        $("#auth_pass").setValue(pass);
        //Нажимаем "Войти"
        $(".button.button_size_large.button_color_green.auth-modal__submit").click();
        //Проверяем имя пользователя по аналогии с предыдущим тестом
        $(".header-topline__user-link").shouldHave(text(username));
    }
}


class AccountRozetkaTests {

    String url = "https://rozetka.com.ua/";
    String email = "testmail@test.qa";
    String pass = "Qwerty321";
    String username = "Тестовый Тест";

    @Test
    void accountDeleteTest() {
        //Открываем сайт
        open(url);
        //Нажимаем на кнопку входа
        $(".header-topline__user-link").click();
        //Вводим почту
        $("#auth_email").setValue(email);
        //Вводим пароль
        $("#auth_pass").setValue(pass);
        //Нажимаем "Войти"
        $(".button.button_size_large.button_color_green.auth-modal__submit").click();
        //Проверяем что залогинились
        $(".header-topline__user-link").shouldHave(text(username));
        //Открываем настройки
        open("https://my.rozetka.com.ua/profile/personal-information/");
        //Нажимаем на кнопку удаления аккаунта
        $(byText("Удалить аккаунт")).click();
        //Подтверждаем удаление в чек-боксе
        $(".remove-account__checkbox").click();
        //Указываем причину удаления
        $("#removeReason").setValue("Because of test");
        //Нажимаем на кнопку "Удалить аккаунт"
        $(".button.button--medium.button--navy").click();
        //Проверяем что нас разлогинило (исходя из этого делаем вывод что аккаунт удален)
        $(".header-topline__user-link").shouldHave(text("войдите в личный кабинет"));
    }
}