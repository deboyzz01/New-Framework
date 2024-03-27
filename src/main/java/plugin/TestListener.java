package plugin;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import plugin.report.GlobalVarReport;

import java.util.Arrays;

public class TestListener implements ITestListener {
    ExtentReports extent = new ExtentReports();


    @Override
    public void onStart(ITestContext context) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent.attachReporter(htmlReporter);
    }


    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        GlobalVarReport.test = extent.createTest(result.getMethod().getMethodName());
        GlobalVarReport.nameTc= result.getMethod().getMethodName();
        System.out.println("result.getMethod().getMethodName() :"+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        GlobalVarReport.test.pass("Test passed");

//        extent.flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        GlobalVarReport.test = extent.createTest(result.getName()); // Create a test with the method name

        Markup errorDetail = MarkupHelper.createCodeBlock("\n"+"Test case failed: " +"\n"+ result.getThrowable().getMessage()+"\n");
        GlobalVarReport.test.fail(errorDetail);
        StackTraceElement[] stackTrace = result.getThrowable().getStackTrace();
        if (stackTrace.length > 0) {
            String errorLocation = "Error at " + stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName() +
                    "(" + stackTrace[0].getFileName() + ":" + stackTrace[0].getLineNumber() + ")";

            Markup error = MarkupHelper.createCodeBlock(errorLocation);
            GlobalVarReport.test.fail(error);
        }




//        Markup error = MarkupHelper.createCodeBlock("\n"+result.getName()+"\n"+result.getThrowable().getMessage()+"\n"+ Arrays.toString(result.getThrowable().getStackTrace()));
//        GlobalVarReport.test.fail(error);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        GlobalVarReport.test.info("Test skipped");
    }

    public void Report(String report){
        System.out.println("GlobalVar.test  :"+ GlobalVarReport.nameTc);
        GlobalVarReport.test.info(report);
    }



    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

}



