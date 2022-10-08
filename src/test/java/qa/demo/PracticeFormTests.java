package qa.demo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    File picture = new File("src/test/resources/picture.jpg");
    String name = "Ivan";
    String surname = "Ivanov";
    String email = "name@example.com";
    String phone = "9876543210";
    String day = "11";
    String month = "November";
    String year = "1995";
    String subject = "Biology";
    String address = "Current Address";
    String state = "NCR";
    String city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void authorizationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(name);
        $("#lastName").setValue(surname);
        $("#userEmail").setValue(email);
        $("#gender-radio-1 + label").click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue(subject).pressEnter();
        $("#hobbies-checkbox-1 + label").click();
        $("#uploadPicture").uploadFile(picture);
        $("#currentAddress").setValue(address);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        $("#submit").click();

        $(".table-responsive table").shouldHave(Condition.text(name + " " + surname));
        $(".table-responsive table").shouldHave(Condition.text(email));
        $(".table-responsive table").shouldHave(Condition.text("Male"));
        $(".table-responsive table").shouldHave(Condition.text(phone));
        $(".table-responsive table").shouldHave(Condition.text(day+" " + month + "," + year));
        $(".table-responsive table").shouldHave(Condition.text(subject));
        $(".table-responsive table").shouldHave(Condition.text("Sports"));
        $(".table-responsive table").shouldHave(Condition.text("picture.jpg"));
        $(".table-responsive table").shouldHave(Condition.text(address));
        $(".table-responsive table").shouldHave(Condition.text(state + " " + city));
    }
}
