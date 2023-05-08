package kendiYaptiklarim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_Ornek08_Locators {

    public static void main(String[] args) throws InterruptedException {
        // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Category bolumundeki elementleri locate edin

        List<WebElement> categoryElements = driver.findElements(By.className("panel-title"));
        // 4- Category bolumunde 3 element oldugunu test edin
        int expectedSize = 3;
        int casualSize = categoryElements.size();

        if (expectedSize == casualSize){
            System.out.println("Test Category : TEST PASSED");
        } else {
            System.out.println("Test Category : TEST FAILED");
        }

        // 5- Category isimlerini yazdirin
        for (WebElement eachCategory:categoryElements) {
            System.out.println(eachCategory.getText());
        }

        // 6- Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();

    }



}
