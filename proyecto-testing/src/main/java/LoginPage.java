import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    private By email = By.id("email");

    private By password = By.id("password");

    private By ingresarButton = By.className("btn-primario");
    private By hello = By.className("txt-hola");
    private By name = By.className("txt-nombre");

    private By mailReq = By.xpath("//*[@id=\"root\"]/main/div/form/div[1]/small");

    private By passReq = By.xpath("//*[@id=\"root\"]/main/div/form/div[2]/small");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, null);
    }

    public void escribirCorreo(String correo) throws InterruptedException{
        this.sendText(correo,email);
    }

    public void escribirPassword(String contrasenia) throws InterruptedException{
        this.sendText(contrasenia,password);
    }

    public void clickLogin() throws InterruptedException{
        this.click(ingresarButton);
    }

    public String saludo() throws InterruptedException{
        return this.getText(hello);
    }

    public String nombre() throws InterruptedException{
        return this.getText(name);
    }


    public String correoObligatorio() throws InterruptedException{
        return this.getText(mailReq);
    }

    public String passObligatoria() throws InterruptedException{
        return this.getText(passReq);
    }

}
