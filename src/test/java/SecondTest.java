import static com.codeborne.selenide.Selenide.*;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SecondTest extends BaseTest{
  @Test
  public void checkThatPageElementAreOllShow(){
    //Hover over Desktops from top menu and click on Desktop option
    $(By.xpath("//li/a[text()='Desktops']")).click();
    //Clicking on Show All Desktops from top menu
    $(By.xpath(
        "//div[@class='dropdown-menu show']/a[@class='see-all']")).click();
    SoftAssertions softly = new SoftAssertions();
    // Comparison that Show dropdown value on 'Desktop' page is the same that 10
    String actualShowSelectValue = $(By.xpath(
        "//label[text()='Show']/following-sibling::select/option[@selected]")).text();
    softly.assertThat(actualShowSelectValue).as("Show value are not the same").isEqualTo("10");
    // Get current sort value on 'Desktop' page
    String actualSortByValue = $(By.xpath(
        "//label[text()='Sort By']/following-sibling::select/option[@selected]")).text();
    // Comparison that selected sort value is the same that 'Default'
    softly.assertThat(actualSortByValue).as("Sort By value are not the same").isEqualTo("Default");
    // Get current desktops count on 'Desktop' page
    int actualDesktopProductCount = $$(By.xpath("//div[@class='product-thumb']")).size();
    // Comparison that current desktop count on 'Desktop' page is the same that 10
    softly.assertThat(actualDesktopProductCount)
        .as("The product count on a page are not the same")
        .isEqualTo(10);
    // Selecting 25 option in 'Show' Select on 'Desktop' page
    Select select = new Select($(By.xpath("//label[text()='Show']/following-sibling::select")));
    select.selectByVisibleText("25");
    // Get current desktops count on 'Desktop' page after changing Show value
    int actualDesktopProductCountAfterSettingShowOption = $$(By.xpath("//div[@class='product-thumb']")).size();
    // Comparison that current desktop count on 'Desktop' page after changing Show value is the same that 10
    softly.assertThat(actualDesktopProductCountAfterSettingShowOption)
        .as("The product count after changes are not the same")
        .isEqualTo(12);
    // Get current showing desktops value
    String actualCountShowingPages = $(By.xpath("//div[@class='col-sm-6 text-end']")).text();
    // Comparison that current showing desktops value on 'Desktop' page is the same that 'Showing 1 to 12 of 12 (1 Pages)'
    softly.assertThat(actualCountShowingPages)
        .as("Showing product count are not the same")
        .isEqualTo("Showing 1 to 12 of 12 (1 Pages)");

    softly.assertAll();
  }

}
