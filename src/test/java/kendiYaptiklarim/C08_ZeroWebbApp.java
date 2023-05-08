package kendiYaptiklarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_ZeroWebbApp {
    //  1. http://zero.webappsecurity.com sayfasina gidin
    //  2. Signin buttonuna tiklayin
    //  3. Login alanine “username” yazdirin
    //  4. Password alanina “password” yazdirin
    //  5. Sign in buttonuna tiklayin
    //  6. Back tusu ile sayfaya donun
    //  7. Online Banking menusunden Pay Bills sayfasina gidin
    //  8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
    //  9. tarih kismina “2020-09-10” yazdirin
    //  10. Pay buttonuna tiklayin
    //  11. “The payment was successfully submitted.” mesajinin
    //  ciktigini test edin

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();

        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        driver.findElement(By.id("sp_amount")).sendKeys("50");


        driver.findElement(By.id("sp_date")).sendKeys("2023-05-08");

        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement Actualtext = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        boolean isTrue = Actualtext.isDisplayed();

        if (isTrue){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.close();


    }
}
