import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends BasePage{


    private By searchBox = By.id("ciudad");

    private By searchButton = By.id("btn-buscador");

    private By searchOk = By.className("categoria");


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void escribirBusqueda(String ciudad) throws InterruptedException{
        this.sendText(ciudad,searchBox);
        this.sendKey(Keys.ENTER, searchBox);
    }

    public void clickBuscar() throws InterruptedException{
        this.click(searchButton);
    }

    public String resultadoBusqueda() throws InterruptedException{
        return this.getText(searchOk);
    }

}
