package qa.demo.testData;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import qa.demo.utils.Hobbie;
import qa.demo.utils.Month;
import qa.demo.utils.Subject;

public class UserInfo {
    Faker faker = new Faker();
    protected String name = faker.name().firstName();
    protected String surname = faker.name().lastName();
    protected String email = faker.internet().emailAddress();
    protected String gender = faker.demographic().sex();
    protected String phone = faker.phoneNumber().subscriberNumber(10);
    protected String day = String.valueOf(faker.number().numberBetween(10, 31));
    protected String month = String.valueOf(Month.getRandomMonth());
    protected String year = String.valueOf(faker.number().numberBetween(1960, 2004));
    protected String subject = String.valueOf(Subject.getRandomSubject());
    protected String hobbie = String.valueOf(Hobbie.getRandomHobbie());
    protected String path = "src/test/resources/picture.jpg";
    protected String address = faker.address().secondaryAddress();
    protected String state = "NCR";
    protected String city = "Delhi";

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
}
