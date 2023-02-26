import static com.codeborne.selenide.Selenide.*;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ZeroTest extends BaseTest{
  @Test
  public void checkAreFollowingBrandsExistOnPage(){
    // Click on 'Brands' at the bottom of the page
    $(By.xpath("//ul[@class='list-unstyled']//a[text()='Brands']")).click();
    // Set expected brands from 'Brands' page
    List<String> expectedResult = Arrays.asList("Apple", "Canon", "Hewlett-Packard", "HTC", "Palm",
        "Sony");
    // Get all present brands from 'Brands' page
    List<String> actualResult = $$(By.xpath("//div[@class='col-sm-3']/a")).texts();
    // Сomparison that all Brands form expected list are the same that actual brands from 'Brands' page
    Assertions.assertThat(actualResult).as("Brands are not the same").containsExactlyElementsOf(expectedResult);

  }

}
