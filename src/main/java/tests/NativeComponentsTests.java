package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import  utils.Steps.*;

public class NativeComponentsTests extends BaseTests {
    private HomePage homePage;
    private MenuPage menuPage;
    NativeComponentsPage nativeComponentsPage;
    NativeComponentsImageCollectionPage nativeComponentsImageCollectionPage;
    NativeComponentsSteps nativeComponentsSteps;
    NativeComponentsContentScrollingPage nativeComponentsContentScrollingPage;


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
}
