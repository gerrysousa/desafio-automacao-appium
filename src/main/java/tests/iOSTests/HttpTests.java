package tests.iOSTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HttpTests extends BaseTests {
    private HomePage homePage;
    private MenuPage menuPage;
    private HttpPage httpPage;

    @Test(priority = 1, description = "Teste para manipular Alert")
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
}
