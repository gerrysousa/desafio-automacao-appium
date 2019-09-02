package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class NativeComponentsTests extends BaseTests {
    private HomePage homePage;
    private MenuPage menuPage;
    NativeComponentsPage nativeComponentsPage;
    NativeComponentsImageCollectionPage nativeComponentsImageCollectionPage;

    @Test(priority = 1, description = "Teste para manipular Alert")
    public void Test_MensagemAlerta() {
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

        Assert.assertEquals(teste2, textoTituloImagemColletion);
    }
}
