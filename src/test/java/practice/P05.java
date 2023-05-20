package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {

    /*
    1 Driver olusturalim
    2 Java class'imiza chromedriver.exe tyi tanitalim
    3 Driverin tum ekrani kaplamasini saglayalim
    4 Driverla sayfanin yukle.809 milisaniye(10 saniye) boyunca beklmesini soyleyelim
    Eger once sayfa yuklenirse beklemeynmesini 10i biraksin
    5 Navigate to http://www.babayigit.net/murat/testpage.htlm
    6 first name, surname, age, your job, birth place, last graduated school, number of children
    alanlarini gerekli bilgileri yazsin
    7 submit tusuna basin
    8 all information was entered correctly yazisinin gorundugunu test etsin
    9 clear butonu ile tum butonlari temizlesin
    10 manuel olarak temizlendigini gorecek kadar beklesin
    11 sayfayi kapatsin
    12 8.Maddedeki test sonucunu yazdirsin
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://www.babayigit.net/murat/testpage.html");

        driver.findElement(By.id("ad")).sendKeys("Burkay");
        driver.findElement(By.id("soyad")).sendKeys("Gül");
        driver.findElement(By.id("yas")).sendKeys("26");
        driver.findElement(By.id("meslek")).sendKeys("Engineer");
        driver.findElement(By.id("dogum_yeri")).sendKeys("Istanbul");
        driver.findElement(By.id("mezun_okul")).sendKeys("Düzce University");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("-");

        driver.findElement(By.xpath("//*[@type='submit']")).click();

        WebElement uyariElement = driver.findElement(By.id("uyari"));

        if (uyariElement.isDisplayed()){
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        driver.findElement(By.xpath("//*[@type='reset']")).click();

        Thread.sleep(5000);

        driver.close();





    }
}
