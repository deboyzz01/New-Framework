package intergrationTest.Menu;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import plugin.TestListener ;

public class Marimas {

    TestListener testListener = new TestListener();

    SoftAssert softAssert = new SoftAssert();


    @Test
    public void yourTestMethod22() {

        System.out.println("aaa");
    }
    @Test

    public void yourTestMethod111() {
        int a =1 ;
        softAssert.assertEquals(a,2);
        softAssert.assertEquals(a,2);
        softAssert.assertEquals(a,2);




        System.out.println("bbb");
        testListener.Report("aku sayang kamu");
        softAssert.assertAll();

    }

    @BeforeTest
    public void BeforeTest(){
    }
}






