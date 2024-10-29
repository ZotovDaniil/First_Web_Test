package tests.SpeechPro;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import static io.qameta.allure.Allure.step;

public class CheckMenuTest extends TestBase {


    @Test
    @DisplayName("Проверка верхнего меню сайта")
    @Tag("menu_checking")
    void checkMenuTest() {

        step("Проверяем на наличие верхнего меню сайта", () -> {

            checkPage.checkMenuHeader("Компания");
            checkPage.checkMenuHeader("Новости");
            checkPage.checkMenuHeader("Карьера");
            checkPage.checkMenuHeader("Контакты");
        });
    }
}
