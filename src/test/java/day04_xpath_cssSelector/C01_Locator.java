package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;


public class C01_Locator {

    public static <List> void main(String[] args) throws InterruptedException {

        // 1- https://www.amazon.com/ sayfasına gidin.
        // 2- Arama kutusuna “city bike” yazip aratin
        // 3- Görüntülenen sonuçların sayısını yazdırın
        // 4- Listeden ilk urunun resmine tıklayın.

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com");


        // 2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusuElement = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElement.sendKeys("city bike" + Keys.ENTER);

        // 3- Görüntülenen sonuçların sayısını yazdırın

        WebElement aramaSonucuElementi = driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucuElementi.getText());

        // 4- Listeden ilk urunun resmine tıklayın.
        java.util.List<WebElement> urunResimElementleriList = driver.findElements(By.className("s-image"));
        urunResimElementleriList.get(0).click();


        Thread.sleep(4000);
        driver.close();
    }
}
