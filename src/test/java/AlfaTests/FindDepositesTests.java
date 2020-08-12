package AlfaTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


class FindDepositesTests {

    @Test
    void findDepositesTest() {

        open("https://alfabank.ru");

        $(byText("Вклады")).hover();
        $(byText("Депозиты")).click();
        $(byText("Архивные депозиты")).click();

        $$(".product-cell__cell").shouldHaveSize(3);

    }
}
