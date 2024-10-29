package tests.SpeechPro;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class SearchingTest extends TestBase {


    @Test
    @Feature("Web Check")
    @Story("Проверка меню и вкладок сайта ЦРТ")
    @Owner("zotovds")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка кнопки поиска на сайте")
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
