import Config.BaseConfig;
import org.junit.Test;
import static io.restassured.RestAssured.given;


public class Test1 extends BaseConfig {



    @Test
    public void checkResponseCode200(){
                given().
                        spec(zippoReqst).
                when().
                        get("bg/4000" ).
                then().
                        spec(zippoResp);


    }
}
