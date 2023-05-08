package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.security.Key;
import java.time.Duration;

public class P04 {
    public static void main(String[] args) {
        /*

    Navigate to website https://testpages.herokuapp.com/styled/index.html
    Under the ORIGINAL CONTENTS
    click on Alerts
    print the URL
    navigate back
    print the URL
    Click on Basic Ajax
    print the URL
    enter value 20 and ENTER
    and then verify Submitted Values is displayed open page
    close driver
     */

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        WebElement alerts = driver.findElement(By.xpath("//a[@id='alerts']"));
        alerts.click();

        System.out.println(driver.getCurrentUrl());

        driver.navigate().back();

        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.xpath("//a[@id='basicajax']")).click();

        System.out.println(driver.getCurrentUrl());


        WebElement giris = driver.findElement(By.id("lteq30"));
        giris.sendKeys("20" + Keys.ENTER);

        String expectedText = "Submitted Values";
        String actualResult= driver.findElement(By.xpath("//*[text()='Submitted Values']")).getText();


        if (actualResult.equals(expectedText)){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.close();





    }
}
