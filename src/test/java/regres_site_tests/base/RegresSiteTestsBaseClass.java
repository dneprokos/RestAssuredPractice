package regres_site_tests.base;

import org.testng.annotations.BeforeClass;
import utils.PropertyManager;
import utils.PropertyNotFoundException;

import static io.restassured.RestAssured.baseURI;

public class RegresSiteTestsBaseClass {
    @BeforeClass
    public void before() throws PropertyNotFoundException {
        baseURI = new PropertyManager("endpoint.properties")
                .getPropertyValue("baseUrl");
    }
}
