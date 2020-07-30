package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

class RegistrationTestRozetka {
    @Test
    void SelenideRegistrationTest() {

            open("https://rozetka.com.ua/");

            $(byText("войдите в личный кабинет")).click();

            $("a[class=\"auth-modal__register-link\"]").click();

            $("input[formcontrolname=\"name\"]").setValue("Тест");

            $("input[formcontrolname=\"username\"]").setValue("testmail1222221@test.com");

            $("input[formcontrolname=\"password\"]").setValue("Qwerty321");

            $("button[type=\"submit\"]").click();

            open("https://my.rozetka.com.ua/profile/personal-information");

            $(byName("profile_accordion_link")).click();

            $(byName("removeReason")).setValue("jfsnfijunserifneis");

            $("img[width=\"26\"][height=\"23\"][src=\"https://i.rozetka.ua/design/_.gif\"]").click();

            $(byText("Удалить мой аккаунт")).click();


    }
}



