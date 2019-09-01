package tests;

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

    @Test(priority = 1, description = "teste de navegacao1")
    public void Test_NestedViewsUpNavigation() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaFinal = "Final Level";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();
        nestedViewsPage.clicarBtnUpNavigation();
        nestedViewsPage.clicarBtnNextLevels();

        String texto = nestedViewsPage.obterTextoLevelFinalNext();
        Assert.assertEquals(texto, textoPaginaFinal);
    }

    @Test(priority = 1, description = "teste de navegacao back")
    public void Test_NestedViewsBackNavigation() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        nestedViewsPage= new NestedViewsPage();

        String textoPaginaFinal = "2";

        homePage.clicarBtnMenu();
        menuPage.clicarBtnNestedViews();
        nestedViewsPage.clicarBtnBackNavigation();
        nestedViewsPage.clicarBtnBackNextLevel();

        String texto = nestedViewsPage.obterTextoLevelFinalBack();
        Assert.assertEquals(texto, textoPaginaFinal);
    }
}
