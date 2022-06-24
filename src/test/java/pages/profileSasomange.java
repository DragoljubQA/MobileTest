package pages;

import base.baseSasomange;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class profileSasomange extends baseSasomange {

    public profileSasomange(AppiumDriver<MobileElement> driver){
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public @AndroidFindBy(id = "selfcare_user_login")
    MobileElement prijaviSeButton;

    public @AndroidFindBy(id = "selfcare_logout")
    MobileElement izlogujSeButton;

    public void navigateToLogin(){prijaviSeButton.click();}
    public void logOutClick(){izlogujSeButton.click();}


}
