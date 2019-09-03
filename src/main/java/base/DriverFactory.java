package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import utils.GlobalParameters;

import java.net.URL;

public class DriverFactory {
    public static AppiumDriver<MobileElement> driver;
    public WebDriverWait wait;
    private static String deviceType;
    private static String environment;
    //private static String path = System.getProperty("user.dir");


    public DriverFactory(String deviceType, String environment) {
        this.deviceType = deviceType;
        this.environment = environment;
    }

    @Parameters({"deviceType"})
    public static AppiumDriver<MobileElement> getDriver() {
        if (driver == null) {
            if (environment.equals("local")){
                DriverFactory.createDriver(deviceType);
            }
            else {
                DriverFactory.createDriverDeviceFarm(deviceType);
            }

        }
        return driver;

    }

    public void setDriver(AppiumDriver<MobileElement> driver) {
        DriverFactory.driver = driver;
    }

    public static AppiumDriver<MobileElement> createDriver(String deviceType){
        try {//environment.equals("deviceFarm")
            if (deviceType.equals("Android")) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", GlobalParameters.AndroidPlatformName);
                caps.setCapability("platformVersion", GlobalParameters.AndroidPlatformVersion);
                caps.setCapability("deviceName", GlobalParameters.AndroidDeviceName);
                caps.setCapability("app", GlobalParameters.AndroidAppPath);
                caps.setCapability("browserName", GlobalParameters.AndroidBrowserName);
                caps.setCapability("udid", GlobalParameters.AndroidUDID);
                caps.setCapability("noReset", GlobalParameters.AndroidNoReset);
                caps.setCapability("fullReset", GlobalParameters.AndroidFullReset);
                caps.setCapability("orientation", GlobalParameters.AndroidOrientation);
                caps.setCapability("automationName", GlobalParameters.AppiumAutomationName);
                driver = new AndroidDriver(new URL(GlobalParameters.AppiumServer), caps);
            }
            else if (deviceType == "IOS")
            {
            }
            //return driver;
        }
        catch (Exception e)
        {
            System.out.print("Vish! Nao conseguiu criar o driver!!!");
        }
        return driver;
    }
    public static AppiumDriver<MobileElement> createDriverDeviceFarm(String deviceType){
        try {
            if (deviceType.equals("Android")) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("platformName", GlobalParameters.AndroidPlatformName);
                caps.setCapability("automationName", GlobalParameters.AppiumAutomationName);
                caps.setCapability("testobject_api_key", GlobalParameters.TestObjectApiKey);
                caps.setCapability("appiumVersion", GlobalParameters.AppiumVersion);

                driver = new AndroidDriver(new URL(GlobalParameters.TestObjectURL), caps);
            }
            else if (deviceType == "IOS") {
            }

        }
        catch (Exception e)
        {
            System.out.print("Vish! Nao conseguiu criar o driver!!!");
        }
        return driver;
    }

    public static void killDriver()     {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
