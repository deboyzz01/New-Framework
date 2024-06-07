package plugin;

import com.aventstack.extentreports.ExtentTest;

public class GlobalVariable {
    public static ExtentTest test;
    public static String nameTc;

    public static String dbUrl_om = "jdbc:oracle:thin:@10.25.136.158:1539/IDOMOPU1";
    public static String dbUsername_om = "DATA_AUTOMATION";
    public static String dbPassword_om = "NEWOMO123";

    public static String baseUrl= "https://octomobile-uat.cimbniaga.co.id";

}
