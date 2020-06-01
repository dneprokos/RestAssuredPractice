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

public class PutUserTestsExample extends RegresSiteTestsBaseClass {

    @Test
    public void updateUserInfo() {
        Integer userId = 2;
        User user = new User("Michael", "Ex basketball player");
        JSONObject reqBody = UserHelpers.createUserJson(user.getName(), user.getJob());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(reqBody.toJSONString())
                .when().put( String.format("users/%d", userId))
                .then()
                .statusCode(200);

        User actualUser = given().get(String.format("users/%d", userId)).as(User.class);
        Assert.assertEquals(actualUser.getName(), user.getName());
        Assert.assertEquals(actualUser.getJob(), user.getJob());
    }


}
