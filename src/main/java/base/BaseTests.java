package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.GlobalParameters;

import java.io.IOException;
import java.lang.reflect.Method;

import static base.DriverFactory.*;
import static base.DriverFactory.getDriver;
import static utils.DataUtils.getDatayyyyMMdd;
import static utils.DataUtils.getHorahhmm;
import static utils.GlobalParameters.PathProject;

//import static utils.Constantes.*;

public class BaseTests {
    private static String log4jConfigurationPath = PathProject+"/output/Reports";
    public static ExtentHtmlReporter relatorio; // =new ExtentHtmlReporter("./output/Reports/learn_automation2.html");
    public static ExtentReports reporter;// = new ExtentReports();
    public static ExtentTest log;
    public static String fileName;
    private WebDriverWait wait;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;

    @BeforeSuite
    public void beforeSuite() {
        new GlobalParameters();

        builder = new AppiumServiceBuilder();
        builder.withIPAddress(GlobalParameters.AppiumIPAddress);
        builder.usingPort(GlobalParameters.AppiumPort);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);

        //Caso queira deixar somente logs de erro no terminal
        //builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        fileName = PathProject+"/output/Reports/Relatorio_"+getDatayyyyMMdd()+"_"+getHorahhmm()+".html";
        relatorio =new ExtentHtmlReporter(fileName);
        reporter = new ExtentReports();
        reporter.attachReporter(relatorio);
        System.setProperty("log4j.configurationFile",log4jConfigurationPath);
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({ "OS", "environment" })
    public void beforeMethod(@Optional("IOS") String deviceType, @Optional("local") String environment, Method method, ITestContext context) {
        // Create Driver
        DriverFactory factory = new DriverFactory(deviceType, environment);
        if (environment.equals("deviceFarm")) {
            driver = factory.createDriverDeviceFarm(deviceType);
        } else {
            driver = factory.createDriver(deviceType);
        }
        // Set up test name and Logger
        setCurrentThreadName();
        Test mt = method.getDeclaredAnnotation(Test.class);
        String description = mt.description();
        String testName = method.getName();
        String className = getClass().getName().substring(6);
        log=reporter.createTest(testName, description);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) throws IOException
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String temp= utils.DataUtils.getScreenshot(getDriver());
            try{
                log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            }
            catch (Exception e){
                log.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            }
        }
        if(result.getStatus()==ITestResult.SUCCESS)
        {
            String temp= utils.DataUtils.getScreenshot(getDriver());
            log.pass("Sucesso!",MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
            log.log(Status.PASS, "Passou fino!!!");
        }
        log.info("[Closing driver]");
        reporter.flush();
        killDriver();
    }

    @AfterSuite
    public void afterSuite(){
        service.stop();
    }

    /** Sets thread name which includes thread id */
    private void setCurrentThreadName() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        String threadId = String.valueOf(thread.getId());
        if (!threadName.contains(threadId)) {
            thread.setName(threadName + " " + threadId);
        }
    }


}
/*
public class TestBaseAndroid {
    private static String log4jConfigurationPath = System.getProperty("user.dir")+"\\src\\test\\java\\com.templateJavaAppium\\";
    private WebDriverWait wait;
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;

    @BeforeSuite
    public void beforeSuite(){
        new GlobalParameters();

        builder = new AppiumServiceBuilder();
        builder.withIPAddress(GlobalParameters.AppiumIPAddress);
        builder.usingPort(GlobalParameters.AppiumPort);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);

        //Caso queira deixar somente logs de erro no terminal
        //builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();

        ExtentReportUtils.createReport();
        System.setProperty("log4j.configurationFile",log4jConfigurationPath);
    }
    @BeforeMethod
    public void beforeTest(Method method) throws Exception {
        ExtentReportUtils.addTest(method.getName(), method.getDeclaringClass().getSimpleName());
        DriveFactory.InitApp("Android");
        wait = new WebDriverWait(DriveFactory.getDriver(), 10);
    }
    @AfterMethod
    public void afterTest(ITestResult result){
        ExtentReportUtils.addTestResult(result);
        DriveFactory.getDriver().quit();
    }
    @AfterSuite
    public void afterSuite(){
        ExtentReportUtils.generateReport();
        service.stop();
    }
}

 */