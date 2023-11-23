package Contract.reqres;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ReqresGetMethods {
    @Test
    public void getListUsers(){
        given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .basePath("/api/users?page=2")
                .param("page", 2)
                .when()
                .get()
                .then()
                .log()
                .body()
                .body(matchesJsonSchemaInClasspath("./contract/schemas/listUser.json"));
    }
}
