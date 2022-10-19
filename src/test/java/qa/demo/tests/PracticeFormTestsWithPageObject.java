package qa.demo.tests;

import org.junit.jupiter.api.Test;
import qa.demo.pages.RegistrationFormPage;
import qa.demo.testData.UserInfo;

public class PracticeFormTestsWithPageObject extends UserInfo {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();



    @Test
    void authorizationFormTest() {
        registrationFormPage.openRegistrationFormPage()
                .setFirstName(name)
                .setLastName(surname)
                .setEmail(email)
                .setGender(gender)
                .setPhone(phone)
                .setBirthDate(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbie)
                .uploadPicture(path)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submit()

                .checkResultsVisible()
                .checkResult("Student Name", name + " " + surname)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phone)
                .checkResult("Date of Birth", day + " "+ month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbie)
                .checkResult("Address", address)
                .checkResult("State and City", "NCR Delhi");
    }
}
