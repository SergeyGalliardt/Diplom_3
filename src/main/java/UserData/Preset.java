package UserData;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class Preset {
    public static RequestSpecification spec() {
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(Constants.MAIN_PAGE)
                .log(LogDetail.ALL)
                .build();
    }
}
