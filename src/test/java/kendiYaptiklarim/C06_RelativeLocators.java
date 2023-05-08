package kendiYaptiklarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C06_RelativeLocators {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

       // 2 ) Sailor’i 3 farkli relative locator ile locate edin

        WebElement movember = driver.findElement(By.id("pid12_thumb"));
        WebElement sailor1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(movember));

        // test etmek icin sailor web elementinin id attribute'nun degerine bakalim - pid7_thumb

        if (sailor1.getAttribute("id").equals("pid11_thumb")){
            System.out.println("sailor Test PASSED");
        } else {
            System.out.println("sailor test FAILED");
        }

        WebElement berlin = driver.findElement(By.id("pid7_thumb"));
        WebElement sailor2 = driver.findElement(RelativeLocator.with(By.tagName("img")).below(berlin));

        if (sailor2.getAttribute("id").equals("pid11_thumb")){
            System.out.println("sailor test2 Passed");
        }  else {
        System.out.println("sailor test2 FAILED");
    }

        WebElement mountie = driver.findElement(By.id("pid10_thumb"));
        WebElement sailor3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(mountie));

        if (sailor3.getAttribute("id").equals("pid11_thumb"))
        {
            System.out.println("TEST 3 PASSED");
        } else {
            System.out.println("TEST 3 FAILED");
        }
        driver.close();
    }
}
