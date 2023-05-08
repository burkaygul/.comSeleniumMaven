package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Xpath {

    public static void main(String[] args) throws InterruptedException {

        //  Relative Xpath Soru

        //  3- Delete butonu’nun gorunur oldugunu test edin
        //  4- Delete tusuna basin
        //  5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //  1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(4000);


        //  2- Add Element butonuna basin
        driver.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(4000);


        //  3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[text()='Delete']"));
        Thread.sleep(4000);


        if (deleteButonu.isDisplayed()){
            System.out.println("Delete Butonu Test PASSED");
        } else {
            System.out.println("Delete Butonu Test FAILED");
        }

        //  4- Delete tusuna basin
        deleteButonu.click();
        Thread.sleep(4000);


        //  5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElement= driver.findElement(By.xpath("//h3"));


        if (addRemoveElement.isDisplayed()){
            System.out.println("Add Remove Element Test PASSED");
        } else {
            System.out.println("Add Remove Element Test FAILED");
        }


        Thread.sleep(4000);
        driver.close();


    }
}
