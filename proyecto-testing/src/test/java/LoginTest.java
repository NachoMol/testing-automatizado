import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportes.ExtentFactory;

import java.time.Duration;

public class LoginTest {
    public WebDriver driver;
    public WebDriverWait wait;

    static ExtentSparkReporter info = new ExtentSparkReporter("target/ReporteLogin.html");
    static ExtentReports extent;

    @BeforeAll
    public static void createReport(){
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void preconditions() throws InterruptedException{
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        LoginPage loginPage = new LoginPage(driver,wait);
        loginPage.setup();
        loginPage.url("https://digital-booking-front.digitalhouse.com/login");


    }


    @Test
    @Tag("LOGIN")
    public void Login_Exitoso() throws InterruptedException{
        ExtentTest test = extent.createTest("Login exitoso");
        test.log(Status.INFO, "Comienza nuestro test de login");
        LoginPage loginPage = new LoginPage(driver,wait);

        loginPage.escribirCorreo("nachotest@gmail.com");
        loginPage.escribirPassword("test123");
        test.log(Status.PASS, "Cargar los datos validos del Login");
        loginPage.clickLogin();

        loginPage.saludo();
        loginPage.nombre();

        test.log(Status.PASS, "Logueado correctamente");

    }

    @Test
    @Tag("LOGIN")
    public void Login_DatosVacios() throws InterruptedException{
        ExtentTest test = extent.createTest("Intentar loguearse sin agregar ningun dato -  Fallido");
        test.log(Status.INFO, "Comienza nuestro test de login");
        LoginPage loginPage = new LoginPage(driver,wait);

        loginPage.escribirCorreo("");
        test.log(Status.PASS, "No se agregan datos de login");

        loginPage.clickLogin();
        loginPage.correoObligatorio();
        loginPage.passObligatoria();

        test.log(Status.PASS, "Se validan los mensajes de campos obligatorios");

    }


    @AfterEach
    public void close(){
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }


    @AfterAll
    public static void saveReport(){
        extent.flush();
    }


}
