package tek.tdd.api.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.ApiTestsBase;

public class GetPrimaryAccountTest extends ApiTestsBase {

    @Test
    public void getAccountAndValidate(){

        RequestSpecification requestSpecification=getDefaultRequest();
        requestSpecification.queryParam("primaryPersonId",10035);
        Response response=requestSpecification.when().get("/api/accounts/get-primary-account");
        response.then().statusCode(200);
        response.prettyPrint();
        String ActualEmail=response.jsonPath().getString("email");
        Assert.assertEquals(ActualEmail,"jawid776@gmail.com");

    }
}
