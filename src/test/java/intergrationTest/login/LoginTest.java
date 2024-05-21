package intergrationTest.login;

import org.testng.annotations.Test;
import plugin.TestListener ;
import service.login.LoginService;
import service.login.request.LoginReqBody;

public class LoginTest {

    TestListener testListener = new TestListener();

    LoginReqBody body = new LoginReqBody();
    @Test
    public void LoginBerhasil() {
        body.setUserId("5mX2dx2xCsd05v0OZ-fd2e29m-9Fq4U=");
        body.setDeviceId("sWj6LgvoGqBzowWan8wRKmaqvwfdx0mjk0yswaNzjVc=");
        body.setOsType("w2L9awGxGjFEO8uDjAxjKUBbvgyAjO4=");
        body.setDeviceInfo("Samsung S20");
        body.setOsVersion("14");
        body.setJailbreakFlag(false);

        LoginService loginService = new LoginService();
        loginService.login("NOgF5_3ClXiI0D7Gf_eXA0CMhstZJ_5RTy7DAHXltV0mtSZT4sJGoYIsj-yaogbOjAW7t5BctTT0cmc14xkr5F928Udql6veD4lL1Hfg4o4w5XR7c4osuyfzg5PgOpzibMfChqFhQ5WGcOmMM0Yz0IClZGTF0SNxcrcW0dQabJaHclHVpUNw5sbtMydy229pB1jJLl0Ne1DQ0pSJOCeF9o0i6UYITezz8M-hQyg7uySBlrHcslMpEU_V3kad-jkIdK-mwSUWBZkG5br_2D32t5pLxcC6H8G-VJO1wuyQqhbKhOu1368pVn4et3_5SGfl3K1RXO7s2oeU4NFdwPwKaQ==",body);

    }
}
