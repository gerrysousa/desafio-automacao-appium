package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsPage extends BasePage {
    @iOSFindBy(xpath= "//XCUIElementTypeNavigationBar")
    @AndroidFindBy(xpath= "com.amazonaws.devicefarm.android.referenceapp:id/toolbar_title")
    private MobileElement lblTitulo;

    @iOSFindBy(accessibility= "Image Gallery")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Image Collection']")
    private MobileElement pageImageCollection;

    @iOSFindBy(accessibility= "Scrolling View")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Content Scrolling']")
    private MobileElement pageContentScrolling;

    @iOSFindBy(accessibility= "Video Player")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Video Player']")
    private MobileElement pageVideoPlayer;

    @iOSFindBy(accessibility= "Camera")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Camera']")
    private MobileElement pageCamera;

    @iOSFindBy(accessibility= "Out of View Component")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Content Out of View']")
    private MobileElement pageContentOutofView;


    //Açoes
    public void acessarImageCollectionPage() {
        clicar(pageImageCollection);
    }

    public void acessarContentScrollingPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            // codigo para android
            acessarImageCollectionPage();

        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            //codigo para iOS
        }

        clicar(pageContentScrolling);
    }

    public void acessarVideoPlayerPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            // codigo para android
            acessarContentScrollingPage();
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            //codigo para iOS
        }

        clicar(pageVideoPlayer);
    }


    public void acessarCameraPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            // codigo para android
            acessarVideoPlayerPage();
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            //codigo para iOS
        }
        clicar(pageCamera);
    }

    public void acessarContentOutofViewPage() {
        if (driver.getCapabilities().getCapability("platformName").toString().equals("Android")) {
            // codigo para android
            acessarCameraPage();
        }
        else if (driver.getCapabilities().getCapability("platformName").toString().equals("iOS"))
        {
            //codigo para iOS
        }
        clicar(pageContentOutofView);
    }

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }

    public String obterNomeDoTitulo() {
        String texto = obterValor(lblTitulo);
        return texto;
    }


}
