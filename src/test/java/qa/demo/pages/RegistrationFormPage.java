package qa.demo.pages;

import com.codeborne.selenide.SelenideElement;
import qa.demo.pages.components.CalendarComponent;
import qa.demo.pages.components.ResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultModal resultModal = new ResultModal();
    private final static String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");
    public RegistrationFormPage openRegistrationFormPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String name){
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationFormPage setLastName(String surname){
        lastNameInput.setValue(surname);
        return this;
    }

    public RegistrationFormPage setEmail(String email){
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage setGender(String gender){
        $("[value=" + gender + "] + label").click();
        return this;
    }

    public RegistrationFormPage setPhone(String phone){
        userNumberInput.setValue(phone);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year){
        dateOfBirthInput.click();
        calendarComponent.setDay(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubjects(String subject){
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationFormPage setHobbies(String hobbie){
        hobbiesInput.$(byText(hobbie)).click();
        return this;
    }

    public RegistrationFormPage uploadPicture(String path){
        uploadPicture.uploadFile(new File(path));
        return this;
    }

    public RegistrationFormPage setAddress (String address){
        addressInput.setValue(address);
        return this;
    }

    public RegistrationFormPage setState (String state){
        stateInput.click();
        subjectsInput.$(byText(state)).click();
        return this;
    }

    public RegistrationFormPage setCity (String city){
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public  RegistrationFormPage submit() {
        submitButton.click();
        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultModal.checkResult(key,value);
        return this;
    }

    public RegistrationFormPage checkResultsVisible() {
        resultModal.checkResultsVisible();
        return this;
    }
}
