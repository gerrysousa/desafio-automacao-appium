package utils.Steps;

import base.BasePage;
import pages.*;

public class NativeComponentsSteps extends BasePage {
    private HomePage homePage = new HomePage();
    private MenuPage menuPage = new MenuPage();
    private NativeComponentsPage nativeComponentsPage = new NativeComponentsPage();


    public void acessarImageCollectionPage()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();
        nativeComponentsPage.acessarImageCollectionPage();
    }

    public void acessarContentScrollingPage()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();
        nativeComponentsPage.acessarContentScrollingPage();
    }

    public void acessarVideoPlayerPage()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();
        nativeComponentsPage.acessarVideoPlayerPage();
    }

    public void acessarCameraPage()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();
        nativeComponentsPage.acessarCameraPage();
    }

    public void acessarContentOutofViewPage()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();
        nativeComponentsPage.acessarContentOutofViewPage();
    }

    public void acessarTableOfElementsPage()
    {
        homePage.clicarBtnMenu();
        menuPage.clicarBtnNativeComponentsPage();
        nativeComponentsPage.acessarpageTableOfElements();
    }
}
