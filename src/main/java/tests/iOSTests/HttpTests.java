package tests.iOSTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HttpTests extends BaseTests {
    private HomePage homePage;
    private MenuPage menuPage;
    private HttpPage httpPage;

    @Test(priority = 1, description = "Teste para acessar site sem colocar url")
    public void Test_HttpAcessarSiteVazio() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        httpPage= new HttpPage();

        String textoTituloDoAlerta = "Faulty URL Entered";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnHttp();

        httpPage.clicarBtnGo();

        String teste2 = httpPage.obterTextoTituloDoAlerta();
        Assert.assertEquals(teste2, textoTituloDoAlerta);
    }

    @Test(priority = 1, description = "Teste para acessar site com url invalida")
    public void Test_HttpAcessarSiteUrlInvalida() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        httpPage= new HttpPage();

        String textoTituloDoAlerta = "Faulty URL Entered";
        String urlInvalida = "www.urlErrada.com";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnHttp();

        httpPage.preencherCampoTexto(urlInvalida);
        httpPage.clicarBtnGo();

        String teste2 = httpPage.obterTextoTituloDoAlerta();
        Assert.assertEquals(teste2, textoTituloDoAlerta);
    }

    @Test(priority = 1, description = "Teste para acessar site com url valida")
    public void Test_HttpAcessarSiteUrlValida() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        httpPage= new HttpPage();

        //String textoBotaoVoltar = "Input a website";
        String urlValida = "https://www.google.com";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnHttp();

        httpPage.preencherCampoTexto(urlValida);
        httpPage.clicarBtnGo();

        boolean existe = httpPage.verificarSeBotaoVoltarExiste();
        Assert.assertTrue(existe);
    }
}
