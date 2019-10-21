package pages;

import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

import java.util.Set;

import static base.DriverFactory.getDriver;

public class LocalWebViewPage extends BasePage {
    @iOSFindBy(xpath = "first-name-form")
    @AndroidFindBy(id = "first-name-form")
    private MobileElement txtFirstName;

    @iOSFindBy(xpath = "last-name-form")
    @AndroidFindBy(id = "last-name-form")
    private MobileElement txtLastName;

    @iOSFindBy(xpath = "Hello!")
    @AndroidFindBy(id = "Hello!")
    private MobileElement lblHelloName;


    //Ações
    public void entrarContextoWeb() {
        Set<String> contextNames = getDriver().getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
       // getDriver().context((String) contextNames.toArray()[1]); // set context to WEBVIEW_1

    }

    public void preencherTxtFirstName(String firstName)
    {
        escrever(txtFirstName,firstName);
    }

    public void preencherTxtLastName(String lastName)
    {
        escrever(txtLastName,lastName);
    }

    public String obterTextoDoElementoLblHelloName() {
        String aux = obterTexto(lblHelloName);
        return aux;
    }

    public void escreverFirstName(String primeiroNome) {
       limparDepoisEscrever(txtFirstName, primeiroNome);
    }

    public void escreverLastName(String ultimoNome) {
        limparDepoisEscrever(txtLastName, ultimoNome);
    }
}
