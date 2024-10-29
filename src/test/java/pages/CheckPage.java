package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class CheckPage {

    private SelenideElement
            menuHeaderLink = $(".header-info");
//            lastNameInput = $("#lastName"),
//            userEmailInput = $("#userEmail"),
//            currentAddressInput = $("#currentAddress"),
//            subjectsInput = $("#subjectsInput"),
//            hobbiesInput = $("#hobbiesWrapper"),
//            uploadPictureInput = $("#uploadPicture"),
//            submitClick=$("#submit");

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
//
//    public CheckPage setLastName(String value) {
//        lastNameInput.setValue(value);
//
//        return this;
//    }
//
//    public CheckPage setUserEmail(String value) {
//        userEmailInput.setValue(value);
//
//        return this;
//    }
//
//    public CheckPage setGender(String value) {
//        $("#genterWrapper").$(byText(value)).click();
//
//        return this;
//    }
//
//    public CheckPage setNumber(String value) {
//        $("#userNumber").setValue(value);
//
//        return this;
//    }
//
//    public CheckPage setBirthDate(String day, String month, String year) {
//        $("#dateOfBirthInput").click();
//        calendarComponent.setDate(day, month, year);
//
//        return this;
//    }
//
//    public CheckPage verifyResultsModalAppears() {
//        registrationResultsModal.verifyModalAppears();
//
//        return this;
//
//    }
//
//    public CheckPage verifyResults(String key, String value) {
//        registrationResultsModal.verifyResults(key, value);
//
//        return this;
//
//    }
//
//    public CheckPage setCurrentAddress(String value) {
//        currentAddressInput.setValue(value);
//
//        return this;
//    }
//
//    public CheckPage setSubjects(String value) {
//        subjectsInput.setValue(value).pressEnter();
//
//        return this;
//    }
//
//    public CheckPage setHobbies(String value) {
//        hobbiesInput.$(byText(value)).click();
//
//        return this;
//    }
//
//    public CheckPage uploadPicture(String value) {
//        uploadPictureInput.uploadFromClasspath(value);
//
//        return this;
//    }
//
//    public CheckPage setPlaceOfLocation(String state, String city) {
//        locationComponent.setLocation(state, city);
//
//        return this;
//    }
//
//    public CheckPage clickSubmit() {
//        submitClick.click();
//        return this;
//    }






