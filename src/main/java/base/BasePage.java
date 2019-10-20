package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalParameters;

import java.time.Duration;
import java.util.HashMap;

import static base.DriverFactory.getDriver;


public class BasePage {
    private static ExtentTest log;
    private static WebDriverWait wait;

    //Variaveis globlais
    protected AppiumDriver driver = null;
    //protected WebDriverWait wait = null;
    protected JavascriptExecutor javaScriptExecutor = null;


    public BasePage() {
        this.log = BaseTests.log;
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()),this);
        driver = getDriver();
        wait = new WebDriverWait (driver, GlobalParameters.TIMEOUT_DEFAULT);
    }

//======================

    protected void esperarElemento(MobileElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void esperarElementoSerClicavel(MobileElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void esperarElementoPorTempo(MobileElement element, int time){
        WebDriverWait waitTime = new WebDriverWait(driver, time);
        waitTime.until(ExpectedConditions.visibilityOf(element));
    }
    protected void clicar(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada+"'");
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();
        while (timeOut.getTime() <= GlobalParameters.TIMEOUT_DEFAULT)
        {
            //WebElement element = null;
            try
            {
                esperarElemento(element);
                element.click();
                //ExtentReportUtils.addTestInfo(3, "");
                //log.info("Clicou no elemento: "+element);
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
    public void clicarAlternativo(By by) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada+"'");
        getDriver().findElement(by).click();
    }

    protected void clicarPorTexto(String texto) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada+"' Clicar no texto: "+texto);
        clicarAlternativo(By.xpath("//*[@text='"+texto+"']"));
    }

    protected void escrever(MobileElement element, String text){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada+"'. Escrever o texto '"+text+"'.");
        esperarElemento(element);
        element.sendKeys(text);
        // ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        //log.info("Escrever o texto '"+text+"' no elemento: "+element);
    }
    protected void escreverSemEsperarSerVisivel(MobileElement element, String text){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        element.sendKeys(text);
        //ExtentReportUtils.addTestInfo(3, "PARAMETER: " + text);
        log.info("Escrever o texto "+text+" no elemento: "+element);
    }
    protected void limparElemento(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        log.info("Limpar o texto do elemento: "+element);
        esperarElemento(element);
        element.clear();
    }
    protected void limparDepoisEscrever(MobileElement element, String text){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        log.info("Limpar o texto do elemento "+element+" e escrever novo texto: "+text);
        esperarElemento(element);
        element.clear();
        element.sendKeys(text);
    }
    protected void limparDepoisEscreverAlternativo(MobileElement element, String text){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        log.info("Limpar o texto do elemento "+element+" e escrever novo texto: "+text);
        esperarElemento(element);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(text);
    }
    protected String obterTexto(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        log.info("Obter texto do elemento: "+element);
        esperarElemento(element);
        String text = element.getText();
        //ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        log.info("Texto do elemento "+element+" = "+text);
        return text;
    }
    protected String obterValor(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        String text = element.getAttribute("value");
        //ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        log.info("Texto do elemento "+element+" = "+text);
        return text;
    }
    protected String obterDescricaoDoElemento(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        String text = element.getAttribute("contentDescription");
        //ExtentReportUtils.addTestInfo(3, "RETURN: " + text);
        log.info("Texto do elemento "+element+" = "+text);
        return text;
    }

    protected boolean retornaSeElementoEstaExibido(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        boolean result = element.isDisplayed();
        //ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        log.info("Elemento "+element+" está visivel = "+result);
        return result;
    }
    protected boolean retornaSeElementoEstaHabilitado(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        boolean result = element.isEnabled();
        //ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        log.info("Elemento "+element+" está habilitado = "+result);
        return result;
    }
    protected boolean retornaSeElementoEstaSelecionado(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        boolean result = element.isSelected();
        //ExtentReportUtils.addTestInfo(3, "RETURN: " + result);
        log.info("Elemento "+element+" está selecionado = "+result);
        return result;
    }
    protected void scrollUsandoAcoesTouch_ByElements(MobileElement startElement, MobileElement endElement, int seconds) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startElement.getLocation().x,startElement.getLocation().y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .moveTo(PointOption.point(endElement.getLocation().x,endElement.getLocation().y)).release().perform();
    }
    protected void scrollUsandoAcoesTouch(int startX,int startY, int endX, int endY, int seconds) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(seconds)))
                .moveTo(PointOption.point(endX,endY)).release().perform();
    }
    protected void pressionarLongo(MobileElement element) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        TouchActions action = new TouchActions(driver);
        action.longPress(element);
        action.perform();
    }
    protected void scrolling(String direction){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        js.executeScript("mobile: scroll", scrollObject);
    }
    protected void tap(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        TouchActions action = new TouchActions(driver);
        action.singleTap(element);
        action.perform();
    }
    protected void doubleTap(MobileElement element){
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        esperarElemento(element);
        TouchActions action = new TouchActions(driver);
        action.doubleTap(element);
        action.perform();
    }

    public void scroll(double inicio, double fim) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        Dimension size =  getDriver().manage().window().getSize();

        int x = size.width/2;

        int startY =(int) (size.height* inicio);
        int endY =(int) (size.height* fim);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(x,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x,endY)).release().perform();
    }

    public void swipe(double inicio, double fim) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada);
        Dimension size =  getDriver().manage().window().getSize();

        int y = size.height/2;

        int start_x =(int) (size.width* inicio);
        int end_x =(int) (size.width* fim);

        TouchAction actions = new TouchAction(driver);
        actions.press(PointOption.point(start_x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x,y)).release().perform();
    }

    public void scrollDown() {
        scroll(0.3, 0.8);
    }

    public void scrollUp() {
        scroll(0.8, 0.3);
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void tirarScreenShotDaTela() {
        try
        {
            String temp = utils.DataUtils.getScreenshot(getDriver());
            log.info("Tirar Screenshot da Tela!", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
        }
        catch (Exception e)
        {

        }
    }

    public boolean verificarSeExisteTextoNaPagina(String texto) {
        log.info("Verifica se existe o texto na pagina, com o valor: '"+texto+"'");
        boolean existe = getDriver().getPageSource().contains(texto);

        return existe;
    }

    public void scrollElement(MobileElement elemento, double inicio, double fim) {
        int x= elemento.getLocation().x + (elemento.getSize().width / 2);

        int start_y =(int) (elemento.getSize().height* inicio);
        int end_y =(int) (elemento.getSize().height* fim);

        TouchAction actions = new TouchAction(getDriver());
        actions.press(PointOption.point(x,start_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(x,end_y)).release().perform();
    }

    public void swipeElement(MobileElement elemento, double inicio, double fim) {
        Dimension size = elemento.getSize();
        int y= elemento.getLocation().y + (elemento.getSize().height / 2);

        int start_x =(int) (elemento.getSize().width* inicio);
        int end_x =(int) (elemento.getSize().width* fim);

        TouchAction actions = new TouchAction(getDriver());
        actions.press(PointOption.point(start_x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(end_x, y)).release().perform();

    }

    public void scrollDirecao(int xInicio,int yInicio,int xFinal,int yFinal) {
        String metodoChamada = Thread.currentThread().getStackTrace()[2].getMethodName();
        log.info("Ação: '" + metodoChamada+"'");
        log.info("Ação scroll com as coordenadas: xInicio="+xInicio+", yInicio="+yInicio+", xFinal="+xFinal+", yFinal="+yFinal+".");
        TouchAction actions = new TouchAction(getDriver());
        actions.tap(PointOption.point(xInicio, yInicio))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(xFinal, yFinal)).release()
                .perform();

    }

    public void scrollDownIOS() {
        scrollDirecao(200,700,200,100);
    }

    public void scrollUpIOS() {
        scrollDirecao(200,100, 200,700);
    }

    public void swipeLeftIOS() {
        scrollDirecao(70,450,350,450);
    }

    public void swipeRightIOS() {
        scrollDirecao(350,450,70,450);
    }
}



