package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_findElements {
    public static void main(String[] args) throws InterruptedException {

        /*
            1- Bir test class'i olusturun ilgili ayarlari yapin
            2- https://www.automationexercise.com/ adresine gidin
            3- Category bolumundeki elementleri locate edin
            4- Category bolumunde 3 elemment oldugunu test edin
            5- Category isimlerini yazdirin
            6- Sayfayi kapatin
         */

        // 1- Bir test class'i olusturun ilgili ayarlari yapin
        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");

        // 3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElementsList = driver.findElements(By.className("panel-title"));
        int expectedSize = 3;
        int actualSize = categoryElementsList.size();

        // 4- Category bolumunde 3 elemment oldugunu test edin
        if (expectedSize == actualSize){
            System.out.println("Category element testi PASSED");
        } else {
            System.out.println("Category element testi PASSED");
        }

        // 5- Category isimlerini yazdirin

        // System.out.println(categoryElementsList);
        /*
            Normalde bir List direkt yazdirilabilir
            Ancak findElements() ile bulunan elementler Webelement oldugundan direk yazdirilamaz

            bir for each loop listenin elementleri yazdirilabilir
         */

        for (WebElement eachElement: categoryElementsList) {
            System.out.println(eachElement.getText());
        }

        // 6-Sayfayi kapatin

        Thread.sleep(3000);
        driver.close();
    }
}
