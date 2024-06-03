package plugin;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;


public class TestListener implements ITestListener {
    ExtentReports extent = new ExtentReports();


    @Override
    public void onStart(ITestContext context) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("sandy.html");
        extent.attachReporter(htmlReporter);
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started");
        GlobalVariable.test = extent.createTest(result.getMethod().getMethodName());
        GlobalVariable.nameTc= result.getMethod().getMethodName();
        System.out.println("result.getMethod().getMethodName() :"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
       System.out.println("Test passed");
        GlobalVariable.test.pass("Test passed");

//        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        Markup errorDetail = MarkupHelper.createCodeBlock("\n"+"Test case failed: " +"\n"+ result.getThrowable().getMessage()+"\n");
        GlobalVariable.test.fail(errorDetail);
        StackTraceElement[] stackTrace = result.getThrowable().getStackTrace();
        if (stackTrace.length > 0) {
            String errorLocation = "Error at " + stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() +
                    "(" + stackTrace[0].getFileName() + ":" + stackTrace[0].getLineNumber() + ")";

            Markup error = MarkupHelper.createCodeBlock(errorLocation);
            GlobalVariable.test.fail(error);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        GlobalVariable.test.info("Test skipped");
    }

    public void Report(String report){
        System.out.println("GlobalVar.test  :"+ GlobalVariable.nameTc);
        GlobalVariable.test.info(report);
    }



    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

}



