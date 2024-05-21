package service.login;

import io.restassured.RestAssured;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import plugin.RemoveCharsetFilter;
import service.login.request.LoginReqBody;
import service.login.respon.LoginRespon;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class LoginService {
    static LoginReqBody body = new LoginReqBody();
    HashMap<String,String> headers = new HashMap<>();


    public void login(String xsecret,LoginReqBody body) {
        RestAssured.baseURI = "https://octomobile-uat.cimbniaga.co.id";
        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

        headers.put("X-Secret", xsecret);
        headers.put("Content-Type", "application/vnd.api.v2+json");

        Response response =
                RestAssured.given().

                        headers(headers).
                        body(body).
                        log().all().
                        when().
                        post("/api/login/authentication/login/userid");

//        System.out.println("response.getHeaders()  " + response.getHeaders());
       response.prettyPrint();

        // Validate the response
        response.then().statusCode(200).extract().as(LoginRespon.class);

    }

}
