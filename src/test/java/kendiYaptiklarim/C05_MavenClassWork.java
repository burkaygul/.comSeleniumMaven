package kendiYaptiklarim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C05_MavenClassWork {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- amazon sayfasina gidelim
        driver.get("https://www.amazon.com/");

        // 2- arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        // 3- "samsung headphones" ile arama yapalim

        searchBox.sendKeys("Samsung headphones");
        searchBox.submit();

        // 4- Bulunan sonuc sayisini yazdiralim

        WebElement sonucSayisi = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println(sonucSayisi.getText());

        // 5- Ilk urune tiklayalim

        WebElement ilkUrun = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-fixed-height'])[1]"));
        ilkUrun.click();

        // 6- Sayfadaki tum basliklari yazdiralim

        List<WebElement> tumBasliklar = driver.findElements(By.id("productTitle"));

        for (WebElement each: tumBasliklar) {
            System.out.println(each.getText());
        }

        Thread.sleep(4000);
        driver.close();
    }
}
