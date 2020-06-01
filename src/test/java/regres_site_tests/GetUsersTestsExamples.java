package regres_site_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import regres_site_tests.base.RegresSiteTestsBaseClass;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class GetUsersTestsExamples extends RegresSiteTestsBaseClass {
    @Test
    public void getUsersTest_ShouldReturnUsersList() {
        Response response = get("/users?page=2");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void bdd_getUsersTest_ShouldReturnUsersList() {
        given()
                .header("Content-Type", "application/json")
                .get("/users?page=2")
        .then()
                .statusCode(200)
                .body("data.first_name",
                        hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"));
    }

    @Test
    public void bdd_getUserTest_ShouldReturnUsersList() {
        given()
                .get("/users/2")
        .then()
                .statusCode(200)
                .log().all()
                .body("data.id", equalTo(2),
                        "data.email", equalTo("janet.weaver@reqres.in"),
                        "data.first_name", equalTo("Janet"),
                        "data.last_name", equalTo("Weaver"),
                        "data.avatar", equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/josephstein/128.jpg"))
                .body("ad.company", equalTo("StatusCode Weekly"),
                        "url", equalTo("http://statuscode.org/"),
                        "text", equalTo("A weekly newsletter focusing on software development, " +
                                "infrastructure, the server, performance, and the stack end of things."));
    }
}
