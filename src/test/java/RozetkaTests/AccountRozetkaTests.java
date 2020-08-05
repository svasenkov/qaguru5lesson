package RozetkaTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class AccountRozetkaTests {

    String url = "https://rozetka.com.ua/";
    String email = "testmail@test.qa";
    String pass = "Qwerty321";
    String username = "Тестовый Тест";

    @Test
    void accountDeleteTest() {

        open(url);

        $(".header-topline__user-link").click(); //Нажимаем на кнопку входа
        $("#auth_email").setValue(email); //Вводим почту
        $("#auth_pass").setValue(pass); //Вводим пароль
        $(".auth-modal__submit").click(); //Нажимаем "Войти"
        $(".header-topline__user-link")
                .shouldHave(text(username)); //Проверяем что залогинились
        open("https://my.rozetka.com.ua/profile/personal-information/"); //Открываем настройки
        $(byText("Удалить аккаунт")).click(); //Нажимаем на кнопку удаления аккаунта
        $(".remove-account__checkbox").click(); //Подтверждаем удаление в чек-боксе
        $("#removeReason").setValue("Because of test"); //Указываем причину удаления
        $(".button--navy").click(); //Нажимаем на кнопку "Удалить аккаунт"


        $(".header-topline__user-link")
                .shouldHave(text("войдите в личный кабинет"));
    }
}
