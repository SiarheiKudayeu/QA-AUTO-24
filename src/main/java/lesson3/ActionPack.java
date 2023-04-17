package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionPack {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\sele\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();



        //Для работы с классом Actions и его методами необходимо создать экземпляр
        //данного класса.
        Actions actions = new Actions(driver);


        //moveByOffset() позволяет наводить курсор на элемент по координатам.
        driver.get("https://uhomki.com.ua/ru/");
        WebElement fishHome = driver.findElement
                (By.xpath("//div[@class='header__wrapper']//a[contains(text(),'Аква')]"));
        int x = fishHome.getLocation().x+(fishHome.getSize().width)/2;
        int y = fishHome.getLocation().y+(fishHome.getSize().height)/2;




        //moveToElement() позволяет наводить курсор на элемент.
        //span[text()='Аквариумы']
/*        actions.moveByOffset(x,y).perform();
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Аквариумы']"))).perform();
        actions.click(driver.findElement(By.xpath("//span[text()='Аквариумы']"))).perform();*/

        /*actions.moveByOffset(x,y).
                moveToElement(driver.findElement(By.xpath("//span[text()='Аквариумы']"))).
                click().build().perform();*/




        //moveToElement(element, int xOffset, int yOffset) позволяет наводить курсор на элемент
        //относительно координат его центра
        /*System.out.println(driver.findElement
                (By.xpath("//span[text()='Аквариумы']")).getSize().height);
        actions.moveByOffset(x,y).
                moveToElement(driver.findElement
                        (By.xpath("//span[text()='Аквариумы']")),0,40).
                click().build().perform();*/


        //click(), позволяет кликать по элементу, либо по месту где находится курсор
        actions.click(fishHome).perform();

        //один из вариантов реализации drag n drop



        //driver.get("https://www.signesduquotidien.org/");



        //keyUp(), keyDown()

        //driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        //Frame
        //contextClick()

        //Alert
        //doubleClick()






    }
}
