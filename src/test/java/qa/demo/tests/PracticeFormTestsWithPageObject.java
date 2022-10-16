package qa.demo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qa.demo.pages.RegistrationFormPage;

public class PracticeFormTestsWithPageObject {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void authorizationFormTest() {
        registrationFormPage.openRegistrationFormPage()
                .setFirstName("Ivan")
                .setLastName("Ivanov")
                .setEmail("name@example.com")
                .setGender("Male")
                .setPhone("9876543210")
                .setBirthDate("11", "November", "1995")
                .setSubjects("Biology")
                .setHobbies("Sports")
                .uploadPicture("src/test/resources/picture.jp")
                .setAddress("Current Address")
                .setState("NCR")
                .setCity("Delhi")
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name","Ivan Ivanov")
                .checkResult("Student Email","name@example.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","9876543210")
                .checkResult("Date of Birth", "11 November,1995")
                .checkResult("Subjects", "Biology")
                .checkResult("Hobbies", "Sports")
                .checkResult("Address", "Current Address")
                .checkResult("State and City", "NCR Delhi");
    }
}
