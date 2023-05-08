package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {
    public static void main(String[] args) throws InterruptedException {

        /*
       // Create a new class with main method
       // Set Path
       // Create a chrome driver
       // Maximize window
       // Open google home page https://www.google.com
       // On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
       // Wait about 4 sn
       // Navigate forward to amazon
       // Refresh page
       // Close/quit the browser
       // And Last step print "All is well" on console
         */
        // Set Path
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        // Create a chrome driver
        WebDriver driver = new ChromeDriver();
        // Maximize window
        driver.manage().window().maximize();
        // Open google home page https://www.google.com
        driver.get("https://www.google.com");
        // On the same class, navigate to amazon home page https://www.amazon.com and navigate back to google
        driver.get("https://www.amazon.com");
        Thread.sleep(2000);
        driver.navigate().back();
        // Wait about 4 sn
        Thread.sleep(4000);
        driver.navigate().forward();
        // Refresh page
        driver.navigate().refresh();
        Thread.sleep(2000);


        // Close/quit the browser
        driver.quit();

        System.out.println("All is well");

    }
}
