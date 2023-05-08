package kendiYaptiklarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C09_GoogleNutella {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.google.com/ adresine gidin
        driver.navigate().to("https://www.google.com/");

        // 3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//*[text()='Alle akzeptieren']")).click();

        // 4- Sayfa basliginin “Google” ifadesi icerdigini test edin

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Titel Test PASSED");
        } else {
            System.out.println("Titel Test FAILED");
        }


        // 5- Arama cubuguna “Nutella” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();

        //6- Bulunan sonuc sayisini yazdirin

        System.out.println(driver.findElement(By.xpath("//*[@id='result-stats']")).getText());


        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin

        WebElement sonucElement = driver.findElement(By.xpath("//*[@id='result-stats']"));
        String sonuc = sonucElement.getText();
        String sonucArr[] = sonuc.split(" "); // {Ungefähr, 129.000.000, Ergenisse, ...}
        System.out.println(Arrays.toString(sonucArr));
        String sonucSayi = sonucArr[1].replaceAll("\\D","");
        int sonucsayi = Integer.parseInt(sonucSayi);
        System.out.println(sonucsayi);

        if (sonucsayi>10000000){
            System.out.println("Arama Sonucu Testi PASSED");
        } else {
            System.out.println("Arama Sonucu Testi FAILED");
        }


        // 8- Sayfayi kapatin

        Thread.sleep(4000);
        driver.close();

    }
}
