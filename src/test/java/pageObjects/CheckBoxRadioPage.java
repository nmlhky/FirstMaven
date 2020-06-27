package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CheckBoxRadioPage {

    public CheckBoxRadioPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".ui-checkboxradio-radio-label>span.ui-checkboxradio-icon")
    List<WebElement> allRadios;

    @FindBy(xpath = "//fieldset[legend[text()='Hotel Ratings: ']]//label//span[1]")
    List<WebElement> allRatings;

    @FindBy(xpath = "//fieldset[legend[text()='Bed Type: ']]//label//span[1]")
    List<WebElement> allBedTypes;

    @FindBy(css = ".ui-checkboxradio-radio-label")
    List<WebElement> allRadios1;

    public int elementSize(String type) {
        int size = 0;
        switch (type){
            case "radios":
                size = allRadios.size();
                break;
            case "rating":
                size = allRatings.size();
                break;
            case "bedTypes":
                size = allBedTypes.size();
                break;
        }
        return size;
    }

    public boolean selectRadio(String city) throws InterruptedException {
        boolean isSelected = false;
        for (WebElement eachRadio: allRadios1) {
            if (eachRadio.getText().equals(city)){
                eachRadio.click();
                Thread.sleep(1000);
                isSelected = eachRadio.findElement(By.xpath("following-sibling::input[1]")).isSelected();
                break;
            }
        }
        return isSelected;
    }

}
