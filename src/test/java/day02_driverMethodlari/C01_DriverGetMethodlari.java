package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        // sisteme webdriver'in ne olacagini ve bu driver'in hangi dosya yolunda oldugunu soyler

        WebDriver driver = new ChromeDriver();
        // bilgisayarimizdaki Chrome browser'in otomasyonla calisacak bir kopyasini olusturur.
        // Chrome disinda bir browser kullanmak istersek o browser'in driver'ini indirip
        // System.setProperty("webdriver.safari.driver","safari driver'in dosya yolu")

        // Olustrudugumuz driver objesi bizim elimiz, gozumuz gibidir

        driver.get("https://wisequarter.com");
        // www yazmazsak da calisir ancak htpps:// yazmazsak calismaz

        System.out.println(driver.getTitle()); // bize title'i dondurur

        System.out.println(driver.getCurrentUrl()); // gidilen url'i dondurur
        // https://wisequarter.com\

        System.out.println(driver.getPageSource());
        // gidilen web sayfasinin kaynak kodlarini dondurur

        System.out.println(driver.getWindowHandle()); // BF003435DE540AB9053790174AA6F8B0
        // acilan her bir pencereye verilen unique hash code degeridir

        System.out.println(driver.getWindowHandles()); // [5E32CEEEFA9CA8E3B32E5EB835A70945]

        // eger driver calisirken birden fazla pencere veya tab olusturduysa
        // acilan tum windows/tablerin unique hash code'larini bir set olarak dondurur

        Thread.sleep(3000); // mili saniye olarak yazdigimiz sayi suresinde kodu bekletir
        driver.close(); // acilan browser'i kapatir



    }
}
