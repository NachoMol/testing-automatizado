import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testGoogle {

    public WebDriver driver;

    public void test_1(){
        driver = new ChromeDriver();
        driver.get("http://google.com");

        driver.getTitle();

        WebElement searchBox = driver.findElement(By.name("q"));

    }

}
