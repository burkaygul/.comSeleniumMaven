package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {

     /*
     . .Exercise2...
    1-Driver oluşturalim
    2-Java class'imiza chnomedriver.exet i tanitalim
    3-Driver'in tum ekranı kaplamasini saglayalim
    4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
    5-"https://www.otto.de” adresine gidelim
    6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
    7-Title ve url inin "0TT0” kelimesinin içerip icermedigini kontrol edelim
    8-Ardindan "https://wisequarter.com/” adresine gidip
    9-BU adresin basligini alalim ve "Quarter” kelimesini icenip icermedigini kontrol edelim
    10-Bir onceki web sayfamiza geri donelim
    11-Sayfayı yenileyelim
    12-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
    13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        driver.get("https://www.otto.de");
        Thread.sleep(3000);


        String ottoTitle = driver.getTitle();
        System.out.println("ottoTitle = " + ottoTitle);

        String ottoUrl = driver.getCurrentUrl();
        System.out.println("ottoUrl = " + ottoUrl);

        if (ottoTitle.contains("OTTO")&&ottoUrl.contains("OTTO")){
            System.out.println("OTTO yazisi her ikisinde de vardir");
        } else{
            System.out.println("En az birinde OTTO yoktur");
        }

        driver.get("https://wisequarter.com/");
        Thread.sleep(3000);

        String expectedBaslik = "Quarter";
        String actualbaslik = driver.getTitle();

        if (actualbaslik.contains(expectedBaslik)){
            System.out.println("Quarter Test PASSED");
        } else {
            System.out.println("Quarter Test FAILED");
        }

        driver.navigate().back();
        Thread.sleep(3000);

        driver.navigate().refresh();
        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.close();
        Thread.sleep(3000);

        driver.close();



    }
}

