package TestBack;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class GETTest {
    @Test
    public void Get_Test01(){
    Response resGet = RestAssured.get("https://reqres.in/api/users?page=2");
    }
}