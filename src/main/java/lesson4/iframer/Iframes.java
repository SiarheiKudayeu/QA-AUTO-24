package lesson4.iframer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_iframe_frameborder_css");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        Thread.sleep(4000);
        WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
        driver.switchTo().frame(frame1);
        Thread.sleep(2000);
        WebElement frame2 = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']/following-sibling::iframe[1]"));
        driver.switchTo().frame(frame2);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        WebElement input = driver.findElement(By.xpath("//input[@id='search2']"));
        input.sendKeys("Найди мне что-то");
    }
}
