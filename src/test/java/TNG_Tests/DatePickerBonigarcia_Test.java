package TNG_Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import managers.DriverMgr;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pageObjects.DatepickerPage;
import pageObjects.JQueryHPage;

@Ignore
public class DatePickerBonigarcia_Test {

    WebDriver driver;
    String baseUrl;
    JQueryHPage jQueryHPage;
    DatepickerPage datepickerPage;

    @BeforeClass
    public void setup() {

        //System.setProperty("webdriver.chrome.driver","C:\IJProjs\\chromedriver.exe");
        baseUrl = "https://jqueryui.com/";
        //WebDriverManager.chromedriver().setup();
        //driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        //driver = DriverMgr.getDriver();
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        jQueryHPage = new JQueryHPage(driver);
        datepickerPage = new DatepickerPage(driver);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void selectDateTest() throws InterruptedException {
        jQueryHPage.clickDatePicker();
        jQueryHPage.switchFrame();
        datepickerPage.clickDatePick();
//        System.setProperty("date","5");
       // datepickerPage.getAllDates("4");
        datepickerPage.getAllDates(System.getProperty("date"));
        Thread.sleep(1000);
    }

}
