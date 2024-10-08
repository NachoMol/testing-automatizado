//Pagina utilizada: https://digital-booking-front.digitalhouse.com/

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    public WebDriver driver;

    @Test
    public void BusquedaExitosa() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://digital-booking-front.digitalhouse.com/");


        Thread.sleep(1000);

        WebElement searchbox = driver.findElement(By.id("ciudad"));

        searchbox.sendKeys("Punta del este");
        searchbox.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        WebElement searchButton = driver.findElement(By.id("btn-buscador"));
        searchButton.click();

        Thread.sleep(1000);

        WebElement searchOk = driver.findElement(By.xpath("//*[@id=\"68\"]/div[2]/div/div[1]"));
        String busquedaCorrecta = searchOk.getText();
        System.out.println(busquedaCorrecta);

        driver.quit();


    }

    @Test
    public void BusquedaExitosaGrecia() throws InterruptedException {

        SearchPage searchPage = new SearchPage(driver);
        searchPage.setup();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");

        Thread.sleep(1000);

        searchPage.escribirBusqueda("Paros");

        Thread.sleep(1000);

        searchPage.clickBuscar();

        Thread.sleep(2000);

        searchPage.resultadoBusqueda();

        searchPage.close();


    }

}
