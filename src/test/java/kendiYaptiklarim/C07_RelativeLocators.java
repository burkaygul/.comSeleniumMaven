package kendiYaptiklarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C07_RelativeLocators {

    public static void main(String[] args) {

        // Toronto Warsaw NYC Boston

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.diemol.com/selenium-4-demo/relative-locators-demo.html sitesine gidelim
        driver.navigate().to("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");

        WebElement warsaw = driver.findElement(By.id("pid1_thumb"));
        WebElement toronto1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(warsaw));

        if (toronto1.getAttribute("id").equals("pid2_thumb")){
            System.out.println("TEST BASARILI");
        } else {
            System.out.println("TEST FAILED");
        }

        WebElement boston = driver.findElement(By.id("pid6_thumb"));
        WebElement toronto2 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(boston));

        if (toronto2.getAttribute("id").equals("pid2_thumb")){
            System.out.println("TEST BASARILI");
        } else {
            System.out.println("TEST FAILED");
        }







    }
}
