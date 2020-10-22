import Config.BaseConfig;
import org.junit.Test;
import static io.restassured.RestAssured.*;


public class Test1 extends BaseConfig {



    @Test
    public void checkResponseCode(){
                given()
                        .spec(zippoReqst)
                        .log()
                        .all()
                .when()
                        .get("bg/4000" )
                .then()
                        .spec(zippoSuccResp)
                        .log()
                        .all();

    }
    @Test
    public void incorrectCheck(){
            given()
                    .spec(zippoReqst)
                    .log()
                    .all()
            .when()
                    .get("/rus/90210")
            .then()
                    .spec(zippoFailResp)
                    .log()
                    .all();
    }
}
