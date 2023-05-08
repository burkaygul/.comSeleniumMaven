package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    /* ...Exercise3...
    Navigate to  https://testpages.herokuapp.com/styled/index.html
    Click on  Calculater under Micro Apps
    Type any number in the first input
    Type any number in the second input
    Click on Calculate
    Get the result
    Print the result
      */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.id("calculatetest")).click();
        driver.findElement(By.id("number1")).sendKeys("12");
        driver.findElement(By.id("number2")).sendKeys("22");

        driver.findElement(By.id("calculate")).click();
        String sonuc = driver.findElement(By.xpath("//*[text()='Answer : ']")).getText();
        System.out.println(sonuc);

        driver.quit();
    }
}
