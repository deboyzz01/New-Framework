package intergrationTest.login;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import plugin.*;
import plugin.dbConnector.login.GlobalVar_login;
import plugin.dbConnector.login.db_login;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {
    TestListener testListener = new TestListener();
    Map<String, Object> requestBody = new HashMap<>();
    Map<String, String> headers = new HashMap<>();
    GlobalVar_login data = new GlobalVar_login();

    @Test
    public void LoginCode() {
        SoftAssert softAssert = new SoftAssert();

        RestAssureFramework apiService = new RestAssureFramework();

        String ts_name = "2";
        String url = GlobalVariable.baseUrl;
        String endpoint = Endpoint.login_endpoint;

        // Authentication details
        String username = "";
        String password = "";

        // Headers
        headers.put("Content-Type", "application/vnd.api.v2+json");
        headers.put("x-secret", "NOgF5_3ClXiI0D7Gf_eXA0CMhstZJ_5RTy7DAHXltV0mtSZT4sJGoYIsj-yaogbOjAW7t5BctTT0cmc14xkr5F928Udql6veD4lL1Hfg4o4w5XR7c4osuyfzg5PgOpzibMfChqFhQ5WGcOmMM0Yz0IClZGTF0SNxcrcW0dQabJaHclHVpUNw5sbtMydy229pB1jJLl0Ne1DQ0pSJOCeF9o0i6UYITezz8M-hQyg7uySBlrHcslMpEU_V3kad-jkIdK-mwSUWBZkG5br_2D32t5pLxcC6H8G-VJO1wuyQqhbKhOu1368pVn4et3_5SGfl3K1RXO7s2oeU4NFdwPwKaQ==");

        // Body
        requestBody.put("user_id", data.user_id.get(ts_name));
        requestBody.put("device_id", data.device_id.get(ts_name));
        requestBody.put("os_type", data.os_type.get(ts_name));
        requestBody.put("device_info", data.device_info.get(ts_name));
        requestBody.put("os_version", data.os_version.get(ts_name));
        requestBody.put("jailbreak_flag", data.jailbreak_flag.get(ts_name));

        // Sending the request and getting the response
        Response response = apiService.sendPostRequest(url, endpoint, headers, requestBody, username, password);


        // Extracting specific field from response body
        String userId = response.jsonPath().getString("timestamp");


        // Extracting specific header from response headers
        String contentType = response.getHeader("access_token");


        softAssert.assertEquals(response.getStatusCode(), 200, "Status Code Check");
        softAssert.assertNotNull(contentType);

        softAssert.assertAll();
        testListener.Report("SEMUA AKSES SUDAH BENAR");

    }





    @BeforeMethod
    public void beforeTest() {
        headers.clear();
        requestBody.clear();
    }

    @BeforeClass
    public void beforeClass() {
        db_login db = new db_login();
        db.ConnectDB();
    }
}
