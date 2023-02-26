import static com.codeborne.selenide.Selenide.open;

import org.testng.annotations.BeforeMethod;

public class BaseTest {
  @BeforeMethod(alwaysRun = true)
  public synchronized void setUp() {
    open("https://demo.opencart.com/");
  }
}
