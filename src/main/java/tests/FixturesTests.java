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

    @Test(priority = 1, description = "Teste para acessar Fixtures e obter status do NFC")
    public void Test_AcessarFixturesObterStatusNFC() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        fixturesPage = new FixturesPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnFixturesPage();

        String textoTitulo = "Fixtures";
        String teste1 = fixturesPage.obterTextoTitulo();
        Assert.assertEquals(teste1, textoTitulo);

        String statusNFC = "false";
        String teste2 = fixturesPage.obterStatusNFC();
        Assert.assertEquals(teste2, statusNFC);
    }

    @Test(priority = 1, description = "Teste para acessar Fixtures e obter status do GPS")
    public void Test_AcessarFixturesObterStatusGPS() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        fixturesPage = new FixturesPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnFixturesPage();

        String textoTitulo = "Fixtures";
        String teste1 = fixturesPage.obterTextoTitulo();
        Assert.assertEquals(teste1, textoTitulo);

        String statusGPS = "false";
        String teste2 = fixturesPage.obterStatusGPS();
        Assert.assertEquals(teste2, statusGPS);
    }

    @Test(priority = 1, description = "Teste para acessar Fixtures e obter status do Bluetooth")
    public void Test_AcessarFixturesObterStatusBluetooth() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        fixturesPage = new FixturesPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnFixturesPage();

        String textoTitulo = "Fixtures";
        String teste1 = fixturesPage.obterTextoTitulo();
        Assert.assertEquals(teste1, textoTitulo);

        String statusBluetooth = "false";
        String teste2 = fixturesPage.obterStatusBluetooth();
        Assert.assertEquals(teste2, statusBluetooth);
    }

    @Test(priority = 1, description = "Teste para acessar Fixtures e obter status do Wi-Fi")
    public void Test_AcessarFixturesObterStatusWiFi() {
        homePage = new HomePage();
        menuPage = new MenuPage();
        fixturesPage = new FixturesPage();

        homePage.clicarBtnMenu();
        menuPage.clicarBtnFixturesPage();

        String textoTitulo = "Fixtures";
        String teste1 = fixturesPage.obterTextoTitulo();
        Assert.assertEquals(teste1, textoTitulo);

        String statusWiFi = "false";
        String teste2 = fixturesPage.obterStatusWiFi();
        Assert.assertEquals(teste2, statusWiFi);
    }
}
