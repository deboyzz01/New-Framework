package intergrationTest.Transfer;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import plugin.TestListener;

import org.testng.asserts.SoftAssert;

public class Marimas1 {

    SoftAssert softAssert = new SoftAssert();
    TestListener testListener = new TestListener();



    @Test
    public void yourTestMethod2() {

        System.out.println("aaa");
    }
    @Test

    public void yourTestMethod1() {
        int a = 1;
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






