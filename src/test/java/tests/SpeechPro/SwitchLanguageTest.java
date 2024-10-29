package tests.SpeechPro;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class SwitchLanguageTest extends TestBase {


    @Test
    @Story("Проверка меню и вкладок сайта ЦРТ")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка выбора языка на сайте")
    @Tag("switch_language")
    void switchLanguageTest() {


        step("Выбор языка", () -> {

            $(".header_language").hover();
            $(".header_language-menu").$(byText("English")).click();
            switchTo().window(1);
            $(".topShTxt__heading").shouldHave(text("SECURE THE FUTURE"));
            switchTo().window(0);

        });
    }
}



