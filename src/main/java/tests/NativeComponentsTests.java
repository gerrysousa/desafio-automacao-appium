package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import  utils.Steps.*;

public class NativeComponentsTests extends BaseTests {
    HomePage homePage;
    MenuPage menuPage;
    NativeComponentsPage nativeComponentsPage;
    NativeComponentsImageCollectionPage nativeComponentsImageCollectionPage;
    NativeComponentsSteps nativeComponentsSteps;
    NativeComponentsContentScrollingPage nativeComponentsContentScrollingPage;
    NativeComponentsVideoPlayerPage nativeComponentsVideoPlayerPage;
    NativeComponentsCameraPage nativeComponentsCameraPage;
    NativeComponentsContentOutOfViewPage nativeComponentsContentOutOfViewPage;


    @Test(priority = 1, description = "Teste para acessar Image Collection")
    public void Test_AcessarImageCollection() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nativeComponentsPage= new NativeComponentsPage();
        nativeComponentsImageCollectionPage = new NativeComponentsImageCollectionPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();

        String textoTitulo = "Native Components";
        String teste1 = nativeComponentsPage.obterTextoTitulo();
        Assert.assertEquals(teste1, textoTitulo);

        String textoTituloImagemColletion = "Image Collection";
        String teste2 = nativeComponentsImageCollectionPage.obterTextoTitulo();
        nativeComponentsImageCollectionPage.tirarScreenShotDaTela();

        Assert.assertEquals(teste2, textoTituloImagemColletion);
    }

    @Test(priority = 1, description = "Teste para acessar Content Scrolling")
    public void Test_AcessarContentScrolling() {
        nativeComponentsSteps = new NativeComponentsSteps();
        nativeComponentsContentScrollingPage = new NativeComponentsContentScrollingPage();

        nativeComponentsSteps.acessarContentScrollingPage();

        String textoTituloImagemColletion = "Content Scrolling";
        String teste2 = nativeComponentsContentScrollingPage.obterTextoTitulo();
        nativeComponentsContentScrollingPage.tirarScreenShotDaTela();

        Assert.assertEquals(teste2, textoTituloImagemColletion);
    }

    @Test(priority = 1, description = "Teste para acessar Video Player")
    public void Test_AcessarVideoPlayer() {
        nativeComponentsSteps = new NativeComponentsSteps();
        nativeComponentsVideoPlayerPage = new NativeComponentsVideoPlayerPage();

        nativeComponentsSteps.acessarVideoPlayerPage();

        String textoTituloImagemColletion = "Video Player";
        String teste2 = nativeComponentsVideoPlayerPage.obterTextoTitulo();
        nativeComponentsVideoPlayerPage.tirarScreenShotDaTela();

        Assert.assertEquals(teste2, textoTituloImagemColletion);
    }

    @Test(priority = 1, description = "Teste para acessar Camera")
    public void Test_AcessarCamera() {
        nativeComponentsSteps = new NativeComponentsSteps();
        nativeComponentsCameraPage = new NativeComponentsCameraPage();

        nativeComponentsSteps.acessarCameraPage();

        String textoTituloImagemColletion = "Camera";
        String teste2 = nativeComponentsCameraPage.obterTextoTitulo();
        nativeComponentsCameraPage.tirarScreenShotDaTela();

        Assert.assertEquals(teste2, textoTituloImagemColletion);
    }

    @Test(priority = 1, description = "Teste para acessar Content Out of View")
    public void Test_AcessarContentOutOfView() {
        nativeComponentsSteps = new NativeComponentsSteps();
        nativeComponentsContentOutOfViewPage = new NativeComponentsContentOutOfViewPage();

        nativeComponentsSteps.acessarContentOutofViewPage();

        String textoTituloImagemColletion = "Content Out of View";
        String teste1 = nativeComponentsContentOutOfViewPage.obterTextoTitulo();
        nativeComponentsContentOutOfViewPage.tirarScreenShotDaTela();
        Assert.assertEquals(teste1, textoTituloImagemColletion);

        nativeComponentsContentOutOfViewPage.scrollUp();
        nativeComponentsContentOutOfViewPage.scrollUp();

        String textoComponenteEscondido = "This is hidden text";
        String teste2 = nativeComponentsContentOutOfViewPage.obterTextoDoComponenteEscondido();
        nativeComponentsContentOutOfViewPage.tirarScreenShotDaTela();
        Assert.assertEquals(teste2, textoComponenteEscondido);
    }





}
