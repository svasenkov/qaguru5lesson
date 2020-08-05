package RozetkaTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class LoginRozetkaTests {

    String url = "https://rozetka.com.ua/";
    String email = "testmail@test.qa";
    String pass = "Qwerty321";
    String username = "Тестовый Тест";

    @Test
    void successfullLoginTest() {

        open(url);

        $(".header-topline__user-link").click(); //Нажимаем кнопку входа
        $("#auth_email").setValue(email); //Вводим почту
        $("#auth_pass").setValue(pass); //Вводим пароль
        $(".auth-modal__submit").click(); //Нажимаем "Войти"

        $(".header-topline__user-link")
                .shouldHave(text(username));
    }
}
