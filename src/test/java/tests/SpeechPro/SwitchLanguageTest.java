package tests.SpeechPro;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static io.qameta.allure.Allure.step;

public class SwitchLanguageTest extends TestBase{


    @Test

    @Story("Проверка меню и вкладок сайта ЦРТ")

    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка сайта")
    @Tag("switch_language")
    void switchLanguageTest() {
        step("Открываем сайт группы компаний ЦРТ", () -> {
            checkPage.openPage();
        });

        step("Выбор языка", () -> {

            $(".header_language").hover();
            $(".header_language-menu").$(byText("English")).click();
            switchTo().window(1);
            $(".topShTxt__heading").shouldHave(text("SECURE THE FUTURE"));
            switchTo().window(0);

        });
    }
}



