import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest{
  SelenideElement desktopMenuButtonLocator = $(By.xpath("//li/a[text()='Desktops']"));
  SelenideElement showAllDesktopButtonLocator = $(By.xpath(
          "//div[@class='dropdown-menu show']/a[@class='see-all']"));
  SelenideElement showDropDownLocator = $(By.xpath(
          "//label[text()='Show']/following-sibling::select/option[@selected]"));
  SelenideElement sortSelectValueLocator = $(By.xpath(
          "//label[text()='Sort By']/following-sibling::select/option[@selected]"));
  ElementsCollection desktopProductCountLocator = $$(By.xpath("//div[@class='product-thumb']"));
  SelenideElement showSelectLocator = $(By.xpath("//label[text()='Show']/following-sibling::select"));
  SelenideElement currentShowingDesktopValueLocator = $(By.xpath("//div[@class='col-sm-6 text-end']"));

  @Test
  public void checkThatPageElementAreOllShow(){
    //Hover over Desktops from top menu and click on Desktop option
    desktopMenuButtonLocator.shouldBe(visible).click();
    //Clicking on Show All Desktops from top menu
    showAllDesktopButtonLocator.shouldBe(visible).click();
    SoftAssertions softly = new SoftAssertions();
    // Comparison that Show dropdown value on 'Desktop' page is the same that 10
    String actualShowSelectValue = showDropDownLocator.shouldBe(visible).text();
    softly.assertThat(actualShowSelectValue).as("Show value are not the same").isEqualTo("10");
    // Get current sort value on 'Desktop' page
    String actualSortByValue = sortSelectValueLocator.shouldBe(visible).text();
    // Comparison that selected sort value is the same that 'Default'
    softly.assertThat(actualSortByValue).as("Sort By value are not the same").isEqualTo("Default");
    // Get current desktops count on 'Desktop' page
    int actualDesktopProductCount =desktopProductCountLocator.shouldBe().size();
    // Comparison that current desktop count on 'Desktop' page is the same that 10
    softly.assertThat(actualDesktopProductCount)
            .as("The product count on a page are not the same")
            .isEqualTo(10);
    // Selecting 25 option in 'Show' Select on 'Desktop' page
    Select select = new Select(showSelectLocator);
    select.selectByVisibleText("25");
    // Get current desktops count on 'Desktop' page after changing Show value
    int actualDesktopProductCountAfterSettingShowOption = desktopProductCountLocator.shouldBe().size();
    // Comparison that current desktop count on 'Desktop' page after changing Show value is the same that 10
    softly.assertThat(actualDesktopProductCountAfterSettingShowOption)
            .as("The product count after changes are not the same")
            .isEqualTo(12);
    // Get current showing desktops value
    String actualCountShowingPages = currentShowingDesktopValueLocator.shouldBe().text();
    // Comparison that current showing desktops value on 'Desktop' page is the same that 'Showing 1 to 12 of 12 (1 Pages)'
    softly.assertThat(actualCountShowingPages)
            .as("Showing product count are not the same")
            .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");

    softly.assertAll();
  }

}
