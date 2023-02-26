import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.WebDriverRunner;
import com.github.javafaker.Faker;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FirstTest extends BaseTest{
  private static final Faker faker = new Faker();
  @Test
  public void checkSuccessfulCreateAccountMessage(){
    //Click on 'My account' icon
    $(By.xpath("//div/a//span[text()='My Account']")).click();
    //Click on 'Register' button
    $(By.xpath("//ul/li/a[text()='Register']")).click();
    // Set first name on 'Register' page
    $(By.xpath("//div/input[@id='input-firstname']")).sendKeys(faker.name().firstName());
    // Set last name on 'Register' page
    $(By.xpath("//div/input[@id='input-lastname']")).sendKeys(faker.name().lastName());
    // Set email on 'Register' page
    $(By.xpath("//div/input[@id='input-email']")).sendKeys(faker.internet().emailAddress());
    // Set password on 'Register' page
    $(By.xpath("//div/input[@id='input-password']")).sendKeys(faker.internet().password());
    // Clicking to NO subscribe option on 'Register' page
    $(By.xpath("//div/input[@id='input-newsletter-no']")).click();
    //Submit Privacy Policy on 'Register' page
    $(By.xpath("//input[@type='checkbox']")).click();
    //Clicking to Continue button on 'Register' page
    $(By.xpath("//button[text()='Continue']")).click();
    // Comparison that current page Url is 'Welcome'
    Assertions
        .assertThat(WebDriverRunner.getWebDriver().getCurrentUrl())
        .as("Page Url is different")
        .isEqualTo("Welcome");







  }

}
