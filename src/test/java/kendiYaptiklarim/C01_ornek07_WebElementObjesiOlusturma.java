package kendiYaptiklarim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ornek07_WebElementObjesiOlusturma {

    public static void main(String[] args) throws InterruptedException {

        // 1- Bir test class'i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- amazon sayfasina gidin

        driver.get("https://www.amazon.com");
        Thread.sleep(3000);

        // 3- amazon arama kutusunu locate edin

        Thread.sleep(3000);

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Thread.sleep(3000);

        // 4- arama kutusuna "Nutella" yazdirin

        aramaKutusu.sendKeys("Nutella");
        Thread.sleep(3000);


        // 5-arama islemini yapabilmek icin Enter 'a basin

        aramaKutusu.submit();
        Thread.sleep(3000);


        // 6- kapatin

        Thread.sleep(3000);
        driver.close();



    }
}
