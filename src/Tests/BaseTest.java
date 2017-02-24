package Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * Created by asus on 09.02.17.
 */


public class BaseTest {

    public WebDriver driver;
    public String baseUrl = "https://app.geteasyqa.com";
    public String email = "vasiliy.fedortsi@thinkmobiles.com";
    public String password = "111111";

    @BeforeMethod
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl + "/users/sign_in");
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }

}
