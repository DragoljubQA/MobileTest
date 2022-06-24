package pages;

import base.baseWordpress;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class signInWordpress extends baseWordpress {

    public signInWordpress(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public @AndroidFindBy(id = "nux_username")
    MobileElement username;

    public @AndroidFindBy(id = "nux_sign_in_button")
    MobileElement nextButton;

    public @AndroidFindBy(id = "password_layout")
    MobileElement passwordLayout;

    public @AndroidFindBy(id = "nux_password")
    MobileElement password;

    public @AndroidFindBy(id = "nux_sign_in_button")
    MobileElement loginButton;


    public void inputUsername(){
        username.clear();
        username.sendKeys("dragoljub.qa@gmail.com");
    }

    public void continueLogin(){
        nextButton.click();
    }

    public void continueWithPassword(){
        passwordLayout.click();
    }

    public void inputPassword(){
        password.clear();
        password.sendKeys("Qwerty123");
    }

    public void clickLogin(){
        loginButton.click();
    }

}
