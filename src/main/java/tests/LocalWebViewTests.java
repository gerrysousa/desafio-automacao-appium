package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LocalWebViewPage;
import pages.MenuPage;


public class LocalWebViewTests extends BaseTests {
    private HomePage homePage;
    private MenuPage menuPage;
    LocalWebViewPage localWebViewPage;

    @Test(priority = 1, description = "teste de Local Web View")
    public void Test_LocalWebView() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        localWebViewPage= new LocalWebViewPage();

        String primeiroNome = "Gerry";
        String ultimoNome = "Sousa";
        String textoInicial = "Hello! Seattle Washington";
        String resultadoFinal = "Hello! Gerry Sousa";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnLocalWebViewPage();

        localWebViewPage.entrarContextoWeb();
        //String teste = localWebViewPage.obterTextoDoElementoLblHelloName();
        //Assert.assertEquals(teste, textoInicial);

        localWebViewPage.escreverFirstName(primeiroNome);
        localWebViewPage.escreverLastName(ultimoNome);

       // String teste2 = localWebViewPage.obterTextoDoElementoLblHelloName();
       // Assert.assertEquals(teste2, resultadoFinal);
    }
}
