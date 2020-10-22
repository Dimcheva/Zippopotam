package Config;

import cucumber.api.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.junit.BeforeClass;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.*;

public class BaseConfig {

    public static RequestSpecification zippoReqst;
    public static ResponseSpecification zippoSuccResp;
    public static ResponseSpecification zippoFailResp;

    @BeforeClass
    public static void setupReq()
    {
         zippoReqst = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();


        zippoSuccResp = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectBody("places[1].'place name'", equalTo("Пловдив / Plovdiv")).
                expectBody("country",equalTo("Bulgaria")).
                build();

        zippoFailResp = new ResponseSpecBuilder().
                expectStatusCode(404).
                //expectBody("country",equalTo("Bulgaria")).
                build();
}
}
