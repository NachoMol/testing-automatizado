//Pagina utilizada: https://digital-booking-front.digitalhouse.com/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchTest {

    public WebDriver driver;

    @BeforeEach
    public void preconditions() throws InterruptedException{
        driver = new ChromeDriver();
        SearchPage searchPage = new SearchPage(driver);
        searchPage.setup();
        searchPage.url("https://digital-booking-front.digitalhouse.com/");


    }

     @Test
    public void BusquedaExitosa() throws InterruptedException {

         SearchPage searchPage = new SearchPage(driver);

         searchPage.escribirBusqueda("Punta del este");

         searchPage.clickBuscar();

         searchPage.resultadoBusqueda();
    }

    @Test
    public void BusquedaExitosaGrecia() throws InterruptedException {

        SearchPage searchPage = new SearchPage(driver);

        searchPage.escribirBusqueda("Paros");

        searchPage.clickBuscar();


        searchPage.resultadoBusqueda();


    }

    @AfterEach
    public void close(){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.close();
    }

}
