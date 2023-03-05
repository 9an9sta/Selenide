import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import java.util.Arrays;
import java.util.List;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ZeroTest extends BaseTest{
  SelenideElement brandsButtonLocator = $(By.xpath("//ul[@class='list-unstyled']//a[text()='Brands']"));
  ElementsCollection allPresentBrandsLocator = $$(By.xpath("//div[@class='col-sm-3']/a"));
  @Test
  public void checkAreFollowingBrandsExistOnPage(){
    // Click on 'Brands' at the bottom of the page
    brandsButtonLocator.shouldBe(visible).click();
    // Set expected brands from 'Brands' page
    List<String> expectedResult = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm",
            "Sony");
    // Get all present brands from 'Brands' page
    List<String> actualResult = allPresentBrandsLocator.shouldBe().texts();
    // Comparison that all Brands form expected list are the same that actual brands from 'Brands' page
    Assertions.assertThat(actualResult).as("Brands are not the same").containsExactlyElementsOf(expectedResult);

  }

}
