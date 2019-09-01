package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage {
    //Mapeamento
    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login Page']")
    private MobileElement btnLoginPage;

    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Input Controls']")
    private MobileElement btnInputControls;

    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nested Views']")
    private MobileElement btnNestedViews;

    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Local Web View']")
    private MobileElement btnLocalWebView;

    //@iOSFindBy(accessibility= "Username Input Field")
    @AndroidFindBy(id = "com.amazonaws.devicefarm.android.referenceapp:id/drawerList")
    private MobileElement menuLista;


    //Fim Mapeamento
    //Ações
    public void clicarBtnLoginPage()
    {
        clicar(btnLoginPage);
    }
    public void clicarInputControls()
    {
        clicar(btnInputControls);
    }

    public void clicarBtnNestedViews()
    {
        clicar(btnNestedViews);
    }

    public void clicarBtnLocalWebViewPage() {
        excutarScrowDownMenuLista();
        clicar(btnLocalWebView);
    }

    public void excutarScrowDownMenuLista() {
        scrollElement(menuLista,0.8, 0.3);
    }
}
