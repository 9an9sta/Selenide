import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
  private static final Faker faker = new Faker();
  SelenideElement myAccountButtonLocator = $(By.xpath("//div/a//span[text()='My Account']"));
  SelenideElement registerButtonLocator = $(By.xpath("//ul/li/a[text()='Register']"));
  SelenideElement firstNameFieldLocator = $(By.xpath("//div/input[@id='input-firstname']"));
  SelenideElement lastNameFieldLocator = $(By.xpath("//div/input[@id='input-lastname']"));
  SelenideElement emailFieldLocator = $(By.xpath("//div/input[@id='input-email']"));
  SelenideElement passwordFieldLocator = $(By.xpath("//div/input[@id='input-password']"));
  SelenideElement NoSubscribeCheckBoxLocator = $(By.xpath("//div/input[@id='input-newsletter-no']"));
  SelenideElement privacyPolicyCheckBoxLocator = $(By.xpath("//input[@type='checkbox']"));
  SelenideElement continueButtonLocator = $(By.xpath("//button[text()='Continue']"));
  //.shouldBe(Condition.visible)
  @Test
  public void checkSuccessfulCreateAccountMessage(){
    //Click on 'My account' icon
    myAccountButtonLocator.shouldBe(visible).click();
    //Click on 'Register' button
    registerButtonLocator.shouldBe(visible).click();
    // Set first name on 'Register' page
    firstNameFieldLocator.shouldBe(visible).sendKeys(faker.name().firstName());
    // Set last name on 'Register' page
    lastNameFieldLocator.shouldBe(visible).sendKeys(faker.name().lastName());
    // Set email on 'Register' page
    emailFieldLocator.shouldBe(visible).sendKeys(faker.internet().emailAddress());
    // Set password on 'Register' page
    passwordFieldLocator.shouldBe(visible).sendKeys(faker.internet().password());
    // Clicking to NO subscribe option on 'Register' page
    NoSubscribeCheckBoxLocator.shouldBe(visible).click();
    //Submit Privacy Policy on 'Register' page
    privacyPolicyCheckBoxLocator.shouldBe(visible).click();
    //Clicking to Continue button on 'Register' page
    continueButtonLocator.shouldBe(visible).click();
    // Comparison that current page Url is 'Welcome'
    Assertions
            .assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
            .as("Page Url is different")
            .isEqualTo("Welcome");







  }

}
