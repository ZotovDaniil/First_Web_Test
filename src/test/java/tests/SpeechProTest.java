package tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


public class SpeechProTest extends TestBase {


    @BeforeAll
    static void beforeAll() {
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Feature("Web Check")
    @Story("Проверка меню и вкладок сайта ЦРТ")
    @Owner("zotovds")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Проверка сайта")
    @Tag("webtest")
    void checkPageTest() {
        step("Открываем сайт группы компаний ЦРТ", () -> {
            checkPage.openPage();
        });

        step("Проверка вкладок в верхнем меню сайта", () -> {
            $(".header-info").shouldHave(text("Компания"));
            $(".header-info").shouldHave(text("Новости"));
            $(".header-info").shouldHave(text("Карьера"));
            $(".header-info").shouldHave(text("Контакты"));
//            registrationPage.setFirstName("Vasya")
//                    .setLastName("Pupkin")
//                    .setUserEmail("email@mail.ru")
//                    .setGender("Other")
//                    .setNumber("1234567890")
//                    .setBirthDate("30", "July", "2007")
//                    .setCurrentAddress("internet")
//                    .setSubjects("Math")
//                    .setHobbies("Sports")
//                    .uploadPicture("img/1.png")
//                    .setPlaceOfLocation("NCR", "Delhi")
//                    .clickSubmit();

        });

        step("Проверка функции поиска на сайте", () ->{
            $("a[href='/search']").click();
            $(".support-find").shouldHave(text("Поиск по сайту"));
            $(".gsc-search-box").click();
            $("#gs_tti50").setValue("Вакансии");
            $("#resInfo-0").shouldHave(text("Найдено результатов:"));
        });


        step("Проверяем заполненную форму", () -> {
            checkPage.verifyResultsModalAppears()
                    .verifyResults("Student Name", "Vasya " + "Pupkin")
                    .verifyResults("Student Email", "email@mail.ru")
                    .verifyResults("Gender", "Other")
                    .verifyResults("Mobile", "1234567890")
                    .verifyResults("Date of Birth", "30 July,2007");
        });

    }
}

