package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class C01_Locator_findElements {

    public static void main(String[] args) throws InterruptedException {



         System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
         WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // genel bir bekleme suresi tanimlama

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusuna Nutelle yazdirip
        /*
            Test otomasyonu yaparken
            bir webelementi kullanmak istersek 2 seye ihtiyacimiz var
            1- o webelemeneti benzersiz olarak tarif edebilecegimiz bir locator
            2- bu locator'i soyledigimizde bize web elementi bulup getirecek method

            ornegin amazon sitesindeki arama kutusunu unique tarif edicisi olarak
            id = "twotabsearchtextbox" kullanabiliriz
         */


        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
      //data turu   objenin adi   =(assignment) find Element : webelementi bulan method
      //                                        By : webelemeneti bulacagimiz locator'in turunu yazdigimiz method
      //                                        twotabsearchtextbox : unique tarif icin id attribute degeri

        /*
            findElement() verdigimiz locator turu ve o locator icin verdigimiz degere gore
            webelement'i arar
            locator icin verdigimiz deger hataliysa veya
            locator stratejisinde hata yaptiysak
            aranan web elementi implicitlyWait olarak tanimladigimiz
            maximum sure boyunca arar
            bulamadigi icin "NoSuchElementException" firlatir ve
            kodlarin kalaninin calistirmaz
         */

        aramaKutusuElementi.sendKeys("Nutella");
        // istenen webelement'e istenen yaziyi gonderir
        // enter tusuna basarak arama yapin

        aramaKutusuElementi.submit();
        // istenen web elementi uzerinde enter tusuna basar


        Thread.sleep(7000); // neden thread.sleep yapiyoruz?
        driver.close();

    }
}
