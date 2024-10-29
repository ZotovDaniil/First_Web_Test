package tests.SpeechPro;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CheckPage;

import java.util.Map;

import static com.codeborne.selenide.Configuration.remote;
import static io.qameta.allure.Allure.step;

public class TestBase {
    CheckPage checkPage = new CheckPage();

    @BeforeAll
    static void BeforeAll() {
        com.codeborne.selenide.Configuration.browserSize = "1920x1080";
        remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

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

    @BeforeEach
    void openPageSpeechPro() {
        step("Открываем сайт группы компаний ЦРТ", () -> {
            checkPage.openPage();
        });
    }
}
