package tek.tdd.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiTestBase {

    public RequestSpecification getDefaultRequest() {
        return RestAssured.given().contentType(ContentType.JSON);
    }

}
