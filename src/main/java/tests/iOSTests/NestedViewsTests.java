package tests.iOSTests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuPage;
import pages.NestedViewsPage;


public class NestedViewsTests extends BaseTests {

    private HomePage homePage;
    private MenuPage menuPage;
    NestedViewsPage nestedViewsPage;

    @Test(priority = 1, description = "teste de navegacao primeira view")
    public void Test_NestedViewsFistView() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaInicial = "This is the first view";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();

        String texto = nestedViewsPage.obterTextoFirstView();
        Assert.assertEquals(texto, textoPaginaInicial);
    }

    @Test(priority = 1, description = "teste de navegacao segunda view")
    public void Test_NestedViewsSecondView() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaFinal = "This is the second view";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();
        nestedViewsPage.clicarBtnNextLevels();

        String texto = nestedViewsPage.obterTextoLevelFinalBack();
        Assert.assertEquals(texto, textoPaginaFinal);
    }

    @Test(priority = 1, description = "teste de navegacao terceira view")
    public void Test_NestedViewsThirdView() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaFinal = "This is the third view";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();
        nestedViewsPage.clicarBtnNextLevels();
        nestedViewsPage.clicarBtnNextLevels();

        String texto = nestedViewsPage.obterTextoThirdView();
        Assert.assertEquals(texto, textoPaginaFinal);
    }

    @Test(priority = 1, description = "teste de navegacao quarta view")
    public void Test_NestedViewsFourthView() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaFinal = "This is the fourth view";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();
        nestedViewsPage.clicarBtnNextLevels();
        nestedViewsPage.clicarBtnNextLevels();
        nestedViewsPage.clicarBtnNextLevels();

        String texto = nestedViewsPage.obterTextoLevelFinalNext();
        Assert.assertEquals(texto, textoPaginaFinal);
    }

    @Test(priority = 1, description = "teste de navegacao ir na quarta view e voltar na terceira view")
    public void Test_NestedViewsFourthViewBackToThird() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaFinal = "This is the third view";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();
        nestedViewsPage.clicarBtnNextLevels();
        nestedViewsPage.clicarBtnNextLevels();
        nestedViewsPage.clicarBtnNextLevels();
        nestedViewsPage.clicarBtnBackNavigation();

        String texto = nestedViewsPage.obterTextoThirdView();
        Assert.assertEquals(texto, textoPaginaFinal);
    }

}
