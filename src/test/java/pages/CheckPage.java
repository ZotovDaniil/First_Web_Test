package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckPage {

    private SelenideElement
            menuHeaderLink = $(".header-info");


    public CheckPage openPage() {
        open("https://www.speechpro.ru/");
        $(".mp-main_wrapper").shouldHave(text("Группа ЦРТ"));
        return this;
    }


    public CheckPage checkMenuHeader(String value) {

        menuHeaderLink.shouldHave(text(value));

        return this;
    }
}



