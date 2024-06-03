package intergrationTest.login;

import io.restassured.response.Response;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import plugin.Endpoint;
import plugin.GlobalVariable;
import plugin.restassure.RestAssureFramework;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    GlobalVariable globalVariable = new GlobalVariable();
    Endpoint point = new Endpoint();
    @Test
    public void LoginCode(){
        SoftAssert softAssert = new SoftAssert();

        RestAssureFramework apiService = new RestAssureFramework();

        String url = GlobalVariable.baseUrl;
        String endpoint= Endpoint.login_endpoint;

        // Authentication details
        String username = "";
        String password = "";

        // Headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/vnd.api.v2+json");
        headers.put("x-secret", "NOgF5_3ClXiI0D7Gf_eXA0CMhstZJ_5RTy7DAHXltV0mtSZT4sJGoYIsj-yaogbOjAW7t5BctTT0cmc14xkr5F928Udql6veD4lL1Hfg4o4w5XR7c4osuyfzg5PgOpzibMfChqFhQ5WGcOmMM0Yz0IClZGTF0SNxcrcW0dQabJaHclHVpUNw5sbtMydy229pB1jJLl0Ne1DQ0pSJOCeF9o0i6UYITezz8M-hQyg7uySBlrHcslMpEU_V3kad-jkIdK-mwSUWBZkG5br_2D32t5pLxcC6H8G-VJO1wuyQqhbKhOu1368pVn4et3_5SGfl3K1RXO7s2oeU4NFdwPwKaQ==");

        // Body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("user_id", "5mX2dx2xCsd05v0OZ-fd2e29m-9Fq4U=");
        requestBody.put("device_id", "sWj6LgvoGqBzowWan8wRKmaqvwfdx0mjk0yswaNzjVc=");
        requestBody.put("os_type", "w2L9awGxGjFEO8uDjAxjKUBbvgyAjO4=");
        requestBody.put("device_info", "Samsung S20");
        requestBody.put("os_version", "14");
        requestBody.put("jailbreak_flag", false);

        // Sending the request and getting the response
        Response response = apiService.sendPostRequest(url, endpoint, headers, requestBody, username, password);


        // Extracting specific field from response body
        String userId = response.jsonPath().getString("timestamp");


        // Extracting specific header from response headers
        String contentType = response.getHeader("access_token");



        softAssert.assertEquals(response.getStatusCode(), 200, "Status Code Check");
        softAssert.assertNotNull(contentType);

        softAssert.assertAll();

    }
    @Test
    public void LoginCode1(){
        SoftAssert softAssert = new SoftAssert();

        RestAssureFramework apiService = new RestAssureFramework();

        String url = GlobalVariable.baseUrl;
        String endpoint= Endpoint.login_endpoint;

        // Authentication details
        String username = "";
        String password = "";

        // Headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/vnd.api.v2+json");
        headers.put("x-secret", "NOgF5_3ClXiI0D7Gf_eXA0CMhstZJ_5RTy7DAHXltV0mtSZT4sJGoYIsj-yaogbOjAW7t5BctTT0cmc14xkr5F928Udql6veD4lL1Hfg4o4w5XR7c4osuyfzg5PgOpzibMfChqFhQ5WGcOmMM0Yz0IClZGTF0SNxcrcW0dQabJaHclHVpUNw5sbtMydy229pB1jJLl0Ne1DQ0pSJOCeF9o0i6UYITezz8M-hQyg7uySBlrHcslMpEU_V3kad-jkIdK-mwSUWBZkG5br_2D32t5pLxcC6H8G-VJO1wuyQqhbKhOu1368pVn4et3_5SGfl3K1RXO7s2oeU4NFdwPwKaQ==");

        // Body
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("user_id", "5mX2dx2xCsd05v0OZ-fd2e29m-9Fq4U=");
        requestBody.put("device_id", "sWj6LgvoGqBzowWan8wRKmaqvwfdx0mjk0yswaNzjVc=");
        requestBody.put("os_type", "w2L9awGxGjFEO8uDjAxjKUBbvgyAjO4=");
        requestBody.put("device_info", "Samsung S20");
        requestBody.put("os_version", "14");
        requestBody.put("jailbreak_flag", false);

        // Sending the request and getting the response
        Response response = apiService.sendPostRequest(url, endpoint, headers, requestBody, username, password);


        // Extracting specific field from response body
        String userId = response.jsonPath().getString("timestamp");


        // Extracting specific header from response headers
        String contentType = response.getHeader("access_token");



        softAssert.assertEquals(response.getStatusCode(), 400);
        softAssert.assertNotNull(contentType);

        softAssert.assertAll();

    }
}
