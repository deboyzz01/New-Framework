package plugin.restassure;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.net.URI;
import java.util.Map;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestAssureFramework {

    public Response sendPostRequest(String url,String endpoint,Map<String, String> headers, Map<String, Object> body, String username, String password) {
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));


        RestAssured.baseURI = url;
        // Sending the request

        return RestAssured.given()
                .log().all()
                .headers(headers)
                .auth().preemptive().basic(username, password)
                .body(body)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }

}
