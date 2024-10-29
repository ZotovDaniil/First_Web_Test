package tests.SpeechPro;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.remote;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchingTest extends TestBase{


    @Test
    @Feature("Web Check")
    @Story("Проверка меню и вкладок сайта ЦРТ")
    @Owner("zotovds")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка сайта")
    @Tag("search")
    void checkSearchTest() {



        step("Проверка функции поиска на сайте", () -> {
            $("a[href='/search']").click();
            $(".support-find").shouldHave(text("Поиск по сайту"));
            $(".gsc-search-box").click();
            $("#gsc-i-id1").setValue("Вакансии").pressEnter();
            $("#resInfo-0").shouldHave(text("Найдено результатов:"));
        });
    }
}
