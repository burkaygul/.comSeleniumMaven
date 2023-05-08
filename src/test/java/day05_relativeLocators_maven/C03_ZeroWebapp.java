package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebapp {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //  1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //  2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click(); // By-id("signin_button")

        //  3. Login alanine “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username"); // By.id("user_login")

        //  4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password"); // By.id("user.password);

        //  5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click(); // By.name("submit")

        //  6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //  7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //  8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("50");

        //  9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2023-05-06");

        //  10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //  11. “The payment was successfully submitted.” mesajinin
        //  ciktigini test edin
        WebElement payment = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        String expectedYazi = "The payment was successfully submitted.";
        String actualYazi = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();

        if (actualYazi.equals(expectedYazi)){
            System.out.println("Mesaj Testi PASSED");
        } else {
            System.out.println("Mesaj Testi FAILED");
        }

        Thread.sleep(4000);
        driver.close();

    }
}
