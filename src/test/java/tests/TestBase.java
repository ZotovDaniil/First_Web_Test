package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.CheckPage;

public class TestBase {
    CheckPage checkPage = new CheckPage();

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";



    }
}
