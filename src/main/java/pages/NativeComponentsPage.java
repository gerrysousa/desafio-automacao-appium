package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class NativeComponentsPage extends BasePage {
    @iOSFindBy(xpath= "com.amazonaws.devicefarm.android.referenceapp:id/toolbar_title")
    @AndroidFindBy(xpath= "com.amazonaws.devicefarm.android.referenceapp:id/toolbar_title")
    private MobileElement lblTitulo;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Image Collection]")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Image Collection']")
    private MobileElement pageImageCollection;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Content Scrolling']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Content Scrolling']")
    private MobileElement pageContentScrolling;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Video Player']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Video Player']")
    private MobileElement pageVideoPlayer;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Camera']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Camera']")
    private MobileElement pageCamera;

    @iOSFindBy(accessibility= "//android.widget.TextView[@text='Content Out of View']")
    @AndroidFindBy(xpath= "//android.widget.TextView[@text='Content Out of View']")
    private MobileElement pageContentOutofView;


    //Açoes
    public void acessarImageCollectionPage() {
        clicar(pageImageCollection);
    }

    public void acessarContentScrollingPage() {
        acessarImageCollectionPage();
        clicar(pageContentScrolling);
    }

    public void acessarVideoPlayerPage() {
        acessarContentScrollingPage();
        clicar(pageVideoPlayer);
    }


    public void acessarCameraPage() {
        acessarVideoPlayerPage();
        clicar(pageCamera);
    }

    public void acessarContentOutofViewPage() {
        acessarCameraPage();
        clicar(pageContentOutofView);
    }

    public String obterTextoTitulo() {
        String texto = obterTexto(lblTitulo);
        return texto;
    }



}
