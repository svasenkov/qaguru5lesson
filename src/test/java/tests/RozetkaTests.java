package tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RozetkaTests {
    String url = "https://rozetka.com.ua/";
    String email = "testmail9379992@test.com";
    String pass = "Qwerty321";
    String username = "Тестовый Тест";

    @Test
    void RegistrationTestRozetka() {
        //Открываем сайт
        open(url);
        //Кликаем на форму входа
        $("a.header-topline__user-link.link-dashed").click();
        //Переходим на форму регистрации
        $("a.auth-modal__register-link").click();
        //Вводим имя
        $("input[formcontrolname=\"name\"]").setValue(username);
        //Вводим почту
        $("input[formcontrolname=\"username\"]").setValue(email);
        //Вводим пароль
        $("input[formcontrolname=\"password\"]").setValue(pass);
        //Нажимаем "Зарегистрироваться"
        $("button[type=\"submit\"]").click();
        //Проверяем что имя которое мы ввели при регистрации совпадает с тем что появилось. Если совпадает - считаем тест успешным
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text(username));
    }

    @Test
    void LoginTestRozetka() {
        //Открываем сайт
        open(url);
        //Нажимаем кнопку входа
        $("a.header-topline__user-link.link-dashed").click();
        //Вводим почту
        $(byId("auth_email")).setValue(email);
        //Вводим пароль
        $(byId("auth_pass")).setValue(pass);
        //Нажимаем "Войти"
        $("button.button.button_size_large.button_color_green.auth-modal__submit").click();
        //Проверяем имя пользователя по аналогии с предыдущим тестом
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text(username));
    }

    @Test
    void AccountDeleteTestRozetka() {
        //Открываем сайт
        open(url);
        //Нажимаем на кнопку входа
        $("a.header-topline__user-link.link-dashed").click();
        //Вводим почту
        $(byId("auth_email")).setValue(email);
        //Вводим пароль
        $(byId("auth_pass")).setValue(pass);
        //Нажимаем "Войти"
        $("button.button.button_size_large.button_color_green.auth-modal__submit").click();
        //Проверяем что залогинились
        $("a.header-topline__user-link.link-dashed").shouldHave(Condition.text(username));
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