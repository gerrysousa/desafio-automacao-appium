package tests;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FixturesPage;
import pages.HomePage;
import pages.MenuPage;

public class FixturesTests extends BaseTests {
    HomePage homePage;
    MenuPage menuPage;
    FixturesPage fixturesPage;


    @Test(priority = 1, description = "Teste para acessar Fixtures")
    public void Test_AcessarFixtures() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        fixturesPage = new FixturesPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnFixturesPage();

        String textoTitulo = "Fixtures";
        String teste1 = fixturesPage.obterTextoTitulo();
        Assert.assertEquals(teste1, textoTitulo);
    }

}
