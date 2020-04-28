package Config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.BeforeClass;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class BaseConfig {

    public static RequestSpecification zippoReqst;
    public static ResponseSpecification zippoResp;

    @BeforeClass
    public static void setupReq()
    {
         zippoReqst = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();


        zippoResp = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectBody("places[1].'place name'", equalTo("Пловдив / Plovdiv")).
                expectBody("country",equalTo("Bulgaria")).
                build();
}
}
