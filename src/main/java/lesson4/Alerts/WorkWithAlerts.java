package lesson4.Alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkWithAlerts {
    public static void main(String[] args) throws InterruptedException {
        //You successfully clicked an alert
        //You clicked: Cancel
        //You entered: asdaasd
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //button[text()='Click for JS Alert']



        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        Thread.sleep(1000);
        System.out.println("Cоответствует ли 1 текст ожидаемому: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText()
                        .equals("You successfully clicked an alert"));

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        alert2.dismiss();
        Thread.sleep(1000);
        System.out.println("Cоответствует 2 ли текст ожидаемому: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText()
                        .equals("You clicked: Cancel"));

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        String text = "введенный текст";
        Alert alert3 = driver.switchTo().alert();
        System.out.println(alert3.getText());
        alert3.sendKeys(text);
        alert.accept();
        Thread.sleep(1000);
        System.out.println("Cоответствует ли текст 3 ожидаемому: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText()
                        .equals("You entered: "+text));
        System.out.println("Cодержится ли тескт: "+
                driver.findElement(By.xpath("//p[@id='result']")).getText().contains(text));
        driver.quit();


    }
}
