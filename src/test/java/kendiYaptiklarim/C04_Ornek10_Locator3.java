package kendiYaptiklarim;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Ornek10_Locator3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.google.chrome", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");

      // 2- Arama kutusuna “city bike” yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike");
        aramaKutusu.submit();

        Thread.sleep(3000);
      // 3- Görüntülenen sonuçların sayısını yazdırın


      // 4- Listeden ilk urunun resmine tıklayın.
    }
}
