package kendiYaptiklarim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Ornek09_Locator2 {

    public static void main(String[] args) throws InterruptedException {

       // 1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        Thread.sleep(3000);

       // 3- Sayfada 147 adet link bulundugunu test edin.

        List<WebElement> links = driver.findElements(By.tagName("a"));
        int expectedLinks = 147;
        int actualLinks = links.size();

        if (expectedLinks==actualLinks){
            System.out.println("Link Test PASSED");
        } else {
            System.out.println("Link Test FAILED");
        }
        Thread.sleep(3000);

        // 4- Products linkine tiklayin

        WebElement productsLink = driver.findElement(By.partialLinkText("Products"));
        productsLink.click();
        Thread.sleep(3000);


        // 5- special offer yazisinin gorundugunu test edin

        WebElement specialOffer = driver.findElement(By.id("sale_image"));
        boolean expectedSpecial = true;
        boolean actualSpecial = specialOffer.isDisplayed();

        if (expectedSpecial == actualSpecial){
            System.out.println("Special TEST PASSED");
        } else {
            System.out.println("Special TEST FAILED");
        }

       // 6- Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();


    }
}
