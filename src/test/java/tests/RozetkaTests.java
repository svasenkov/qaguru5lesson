package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RozetkaTests {
    @Test
    void RegistrationTestRozetka() {
        //Открываем сайт
        open("https://rozetka.com.ua/");
        //Кликаем на форму входа
        $("a.header-topline__user-link.link-dashed").click();
        //Переходим на форму регистрации
        $("a.auth-modal__register-link").click();
        //Вводим имя
        $("input[formcontrolname=\"name\"]").setValue("Тестовый Тест");
        //Вводим почту
        $("input[formcontrolname=\"username\"]").setValue("testmail9379992@test.com");
        //Вводим пароль
        $("input[formcontrolname=\"password\"]").setValue("Qwerty321");
        //Нажимаем "Зарегистрироваться"
        $("button[type=\"submit\"]").click();
        //Проверяем что имя которое мы ввели при регистрации совпадает с тем что появилось. Если совпадает - считаем тест успешным
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text("Тестовый Тест"));
    }

    @Test
    void LoginTestRozetka() {
        //Открываем сайт
        open("https://rozetka.com.ua/");
        //Нажимаем кнопку входа
        $("a.header-topline__user-link.link-dashed").click();
        //Вводим почту
        $(byId("auth_email")).setValue("testmail9379992@test.com");
        //Вводим пароль
        $(byId("auth_pass")).setValue("Qwerty321");
        //Нажимаем "Войти"
        $("button.button.button_size_large.button_color_green.auth-modal__submit").click();
        //Проверяем имя пользователя по аналогии с предыдущим тестом
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text("Тестовый Тест"));
    }

    @Test
    void AccountDeleteTestRozetka() {
        //Открываем сайт
        open("https://rozetka.com.ua/");
        //Нажимаем на кнопку входа
        $("a.header-topline__user-link.link-dashed").click();
        //Вводим почту
        $(byId("auth_email")).setValue("testmail9379992@test.com");
        //Вводим пароль
        $(byId("auth_pass")).setValue("Qwerty321");
        //Нажимаем "Войти"
        $("button.button.button_size_large.button_color_green.auth-modal__submit").click();
        //Проверяем что залогинились
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text("Тестовый Тест"));
        //Открываем настройки
        open("https://my.rozetka.com.ua/profile/personal-information/");
        //Нажимаем на кнопку удаления аккаунта
        $(byText("Удалить аккаунт")).click();
        //Подтверждаем удаление в чек-боксе
        $("div.form__row.remove-account__checkbox").click();
        //Указываем причину удаления
        $(byId("removeReason")).setValue("Because of test");
        //Нажимаем на кнопку "Удалить аккаунт"
        $("button.button.button--medium.button--navy").click();
        //Проверяем что нас разлогинило (исходя из этого делаем вывод что аккаунт удален)
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text("войдите в личный кабинет"));
    }
}