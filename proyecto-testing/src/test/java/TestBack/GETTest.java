package TestBack;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class GETTest {
    @Test
    public void Get_Test01(){
    Response resGet = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(resGet.getBody().asString());
        System.out.println(resGet.statusCode());
        System.out.println(resGet.getHeader("Date"));
        System.out.println(resGet.getTime());
    }

    @Test
    public void Get_Test02(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");

        int statusCode = response.statusCode();
        JsonPath body = response.jsonPath();
        String nombre_0 = body.getString("data.first_name[0]");
        String email_0 = body.getString("data.email[0]");

        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(nombre_0,"Michael");

        System.out.println(statusCode);
        System.out.println(nombre_0);
        System.out.println(email_0);

    }
}
