package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
import java.util.HashMap;
import utils.GlobalParameters;

public class BasePage {
//    private static ExtentTest log;
//    private static WebDriverWait wait;
//
//    public BasePage() {
//        this.log = BaseTests.log;
//        wait =  new WebDriverWait(getDriver(), 5);
//        PageFactory.initElements(getDriver(), this);
//    }
//
//    public void escrever(WebElement element, String texto) {
//        AguardarLoading();
//        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
//        try {
//            log.info("Ação: '" + metodoChamada + "' com o valor: '"+texto+"'");
//            wait.until(ExpectedConditions.elementToBeClickable(element)).clear();
//            element.sendKeys(Keys.CONTROL + "a");
//            element.sendKeys(Keys.DELETE);
//            element.sendKeys(texto);
//        }
//        catch (Exception e){
//            log.error("Não conseguiu executar a ação: '"+ metodoChamada+"'");
//            try {
//                // log.fail("", MediaEntityBuilder.createScreenCaptureFromPath(ScreenShot.captureScreen()).build());
//                log.error(e.toString());
//            } catch (Exception e1) {
//                e1.printStackTrace();
//            }
//        }
//    }


    //Variaveis globlais
    protected AppiumDriver driver = null;
    protected WebDriverWait wait = null;
    protected JavascriptExecutor javaScriptExecutor = null;

    //Construtor
    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.getDriver()),this);
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait (driver, GlobalParameters.TIMEOUT_DEFAULT);
    }

    protected void waitForElement(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementToBeClickeable(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitForElementByTime(MobileElement element, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.visibilityOf(element));
    }
    protected void click(MobileElement element){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            //WebElement element = null;
            try
            {
                waitForElement(element);
                element.click();
                ExtentReportUtils.addTestInfo(3, "");
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e) {
                continue;
            }
            catch (WebDriverException e)
            {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }
                throw e;
            }
        }
        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    protected void sendKeys(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }
    protected void sendKeysWithoutWaitVisible(MobileElement element, String text){
        element.sendKeys(text);
        ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
    }
    protected void clear(MobileElement element){
        waitForElement(element);
        element.clear();
    }
    protected void clearAndSendKeys(MobileElement element, String text){
        waitForElement(element);
        element.clear();
        element.sendKeys(text);
    }
    protected void clearAndSendKeysAlternative(MobileElement element, String text){
        waitForElement(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }
    protected String getText(MobileElement element){
        waitForElement(element);
        String text = element.getText();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return text;
    }
    protected String getValue(MobileElement element){
        waitForElement(element);
        String text = element.getAttribute("value");
        ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        return text;
    }
    protected boolean returnIfElementIsDisplayed(MobileElement element){
        waitForElement(element);
        boolean result = element.isDisplayed();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }
    protected boolean returnIfElementIsEnabled(MobileElement element){
        waitForElement(element);
        boolean result = element.isEnabled();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }
    protected boolean returnIfElementIsSelected(MobileElement element){
        waitForElement(element);
        boolean result = element.isSelected();
        ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        return result;
    }
    protected void scrollUsingTouchActions_ByElements(MobileElement startElement, MobileElement endElement, int seconds) {
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startElement.getLocation().x,startElement.getLocation().y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .moveTo(PointOption.point(endElement.getLocation().x,endElement.getLocation().y)).release().perform();
    }
    protected void scrollUsingTouchActions(int startX,int startY, int endX, int endY, int seconds) {
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .moveTo(PointOption.point(endX,endY)).release().perform();
    }
    protected void longPress(MobileElement element) {
        waitForElement(element);
        TouchActions action = new TouchActions(driver);
        action.longPress(element);
        action.perform();
    }
    protected void scrolling(String direction){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: scroll", scrollObject);
    }
    protected void tap(MobileElement element){
        waitForElement(element);
        TouchActions action = new TouchActions(driver);
        action.singleTap(element);
        action.perform();
    }
    protected void doubleTap(MobileElement element){
        waitForElement(element);
        TouchActions action = new TouchActions(driver);
        action.doubleTap(element);
        action.perform();
    }
}