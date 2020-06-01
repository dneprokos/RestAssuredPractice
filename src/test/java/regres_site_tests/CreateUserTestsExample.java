package regres_site_tests;

import helpers.UserHelpers;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import regres_site_objects.User;
import regres_site_tests.base.RegresSiteTestsBaseClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class CreateUserTestsExample extends RegresSiteTestsBaseClass {
    @Test
    public void createUser_UserShouldBeCreated() {
        User user = new User("Kostia", "Senior QA Automation");
        JSONObject reqBody = UserHelpers.createUserJson(user.getName(), user.getJob());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(reqBody.toJSONString())
        .when().post("/users")
        .then()
                .statusCode(201)
                .body("name", equalTo(user.getName()), "job", equalTo(user.getJob()))
                .log().all();
    }

    @Test
    public void createUser_AssertWithObjectProperties() {
        User user = new User("Kostia", "Senior QA Automation");
        JSONObject reqBody = UserHelpers.createUserJson(user.getName(), user.getJob());

        User userResponse =
                given()
                    .header("Content-Type", "application/json")
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON)
                    .body(reqBody.toJSONString())
                .when()
                        .post("/users")
                        .as(User.class);

        //Need some library or wrapper to assert in one line
        Assert.assertEquals(userResponse.getName(), user.getName());
        Assert.assertEquals(userResponse.getJob(), user.getJob());
    }


}
