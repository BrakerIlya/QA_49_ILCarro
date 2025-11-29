package pages;

import dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }
    @FindBy(id="email")
    WebElement inputEmail;
    @FindBy(id="password")
    WebElement inputPassword;
    @FindBy(xpath="//button[@type='submit']")
    WebElement btnYalla;
    @FindBy(xpath="//h2[text()='Logged in success']")
    WebElement popUpTestLogged;
    @FindBy(xpath ="//h2[text()='\"Login or Password incorrect\"']" )
    WebElement popUpTextLoggedIncorrect;
    @FindBy(xpath = "//button[text()=\"Ok\"]")
    WebElement btnOk;
    public void typeLoginForm(User user){
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnYalla.click();
    }
    public boolean isLoggedDisplayed(){
        return elementIsDisplayed(popUpTestLogged);
    }
    public boolean isLoggedIncorrect(){
        return elementIsDisplayed(popUpTextLoggedIncorrect);
    }
    public boolean isYallaEnabled(){
        return elementIsEnabled(btnYalla);
    }

    public void clickBtnOk() {
        clickWait(btnOk,3);

    }
}
