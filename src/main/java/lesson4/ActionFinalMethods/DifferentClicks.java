package lesson4.ActionFinalMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DifferentClicks {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Thread.sleep(4000);
        driver.switchTo().frame("gdpr-consent-notice");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Принять всё']")).click();
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        System.out.println("Совпадает ли текст 1 модального окна? " + alert.getText().equals("clicked: delete"));
        alert.accept();
        Thread.sleep(1000);
        actions.doubleClick(driver.findElement
                (By.xpath("//button[text()='Double-Click Me To See Alert']"))).click().perform();
        Thread.sleep(1000);
        driver.switchTo().alert();
        System.out.println("Совпадает ли текст 2 модального окна? "
                + alert.getText().equals("You double clicked me.. Thank You.."));
        alert.dismiss();
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
