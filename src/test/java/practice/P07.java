package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P07 {

    public static void main(String[] args) {

        System.setProperty("webdriver.google.chrome", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");

        //2 ) Nurse  3 farkli relative locator ile locate edin

        WebElement firemanElement = driver.findElement(By.id("frmn_thumb"));
        WebElement nurse1 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(firemanElement));

        if (nurse1.getAttribute("id").equals("nurs_thumb")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }


        WebElement sellerElement = driver.findElement(By.id("sll_thumb"));
        WebElement nurse2 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(sellerElement));

        if (nurse2.getAttribute("id").equals("nurs_thumb")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        WebElement policemanElement = driver.findElement(By.id("pol_thumb"));
        WebElement nurse3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(policemanElement));

        if (nurse3.getAttribute("id").equals("nurs_thumb")){
            System.out.println("test passed");
        }else{
            System.out.println("test failed");
        }

        //3 ) Relative locator’larin dogru calistigini test edin


        }
}
