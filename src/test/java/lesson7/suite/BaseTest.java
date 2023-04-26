package lesson7.suite;

import lesson5.MyWaiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static WebDriver driver;

    public static WebDriver startDriver(){
        if(driver==null){
            try {
                {
                    System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }return driver;
    }

    @BeforeSuite
    public void driverInitialisation() {
        driver = startDriver();
        driver.get("https://klopotenko.com/");
        new MyWaiters(driver).waitPresenceOfElementReturn(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
    }

    @AfterSuite
    public void closeDriver() {
        driver.quit();
    }

}
