package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_IlkTest {

    public static void main(String[] args) throws InterruptedException {
        // once gerekli ayarlamalari yapip driver objesi olusturmaliyiz
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // 3.Amazon sayfasina gidelim
        driver.get("https://amazon.de");
        // 4. Sayfa baslinigini(title) yazdirin
        System.out.println(driver.getTitle());
        // 5. Sayfa basliginin "Amazon icerdigini test edin
        // yazilim testi, beklenen degerlerin gerceklesip gerceklesmedigini test etmektir.

        String expectedIcerik = "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title Amazon iceriyor, Test PASSED");
        } else {
            System.out.println("Title Amazon icermiyor, Test FAILED");
        }

        // 6.sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        // 7. sayfa url'inin "amazon" icerdigini test edin.
        expectedIcerik = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains("amazon")){
            System.out.println("Url amazon iceriyor, URL Test PASSED");
        } else {
            System.out.println("Url amazon icermiyor, URL Test FAILED");
        }

        // 8. Sayfa handle degerini yazdirin
        System.out.println("Sayfanin handle degeri : " +driver.getWindowHandle());

        // 9. Sayfa HTML kodlarinda "alisveris" kelimesi gectigini test edin

        expectedIcerik = "Einkaufen";
        String actualPageSource = driver.getPageSource();

        if (actualPageSource.contains(expectedIcerik)){
            System.out.println("HTML Einkaufen iceriyor, HTML Test PASSED");
        } else {
            System.out.println("HTML Einkaufen icermiyor, HTML Test FAILED");
        }


        // 10.Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();

    }
}
