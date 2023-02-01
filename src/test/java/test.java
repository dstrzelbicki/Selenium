import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1280, 720));
    }

    @AfterEach
    public void closeAndQuit(){
        driver.close();
        driver.quit();
    }

    @Test
    public void navigate(){
        driver.get("https://allegro.pl");
        driver.navigate().to("https://www.olx.pl");
        driver.navigate().back();
        String allegroTitle = "Allegro - atrakcyjne ceny - Strona Główna";
        Assertions.assertEquals(allegroTitle, driver.getTitle(), "The title of the page is not: " + allegroTitle);
        driver.navigate().forward();
        String olxTitle = "Ogłoszenia - Sprzedam, kupię na OLX.pl";
        Assertions.assertEquals(olxTitle, driver.getTitle(), "The title of the page is not: " + olxTitle);
    }

}
