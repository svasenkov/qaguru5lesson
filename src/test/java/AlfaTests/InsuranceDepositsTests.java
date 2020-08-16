package AlfaTests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;

class InsuranceDepositsTests {

    String url = "https://alfabank.ru";

    @Test
    void siblingInsuranceDepositsTests() {

        open(url);

        $(byText("Вклады")).click();
        $(".selected").sibling(4).click();

        $(".col-xs-8 h1")
                .shouldHave(text("Страхование вкладов"));

    }
}