package com.sample.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class WordPressTest {

    //Ovo je test na fizicki uredjaj koji je prikacen na PC, potrebno je odobriti USB debugging
    //USB debug se odobrava iz developer options
    @Test
    public void openApp() throws MalformedURLException, InterruptedException {
        AppiumDriver<MobileElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/WordPress.apk");
        //u narednoj liniji otvaramo homepage aplikacije, ako nam treba sign in page onda je drugaciji app activity
        //capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,"org.wordpress.android.ui.main.WPMainActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY,"org.wordpress.android.ui.accounts.SignInActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        //NO RESET pokrece trenutno stanje aplikacije, ne pokrece ponovo instalaciju ili brise cache
        //ova sledeca linija koja je zakomentarisana predstavlja full reset sto znaci aplikacija ce se reinstalirati, to je kao primer i ne treba nam sada
        //capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        //driver.get("www.youtube.com");
        //Thread.sleep(3000);
        //ove dve linije iznad su za testiranje weba preko telefona

        Thread.sleep(2000);
        driver.findElement(By.id("nux_username")).sendKeys("vodqa@gmail.com");
        driver.findElement(By.id("nux_sign_in_button")).click();
        Thread.sleep(2000);
        MobileElement passwordDugme = driver.findElement(By.id("password_layout"));
        passwordDugme.click();
        driver.findElement(By.id("nux_password")).sendKeys("Hello12345678");
        driver.findElement(By.id("nux_sign_in_button")).click();
        Thread.sleep(2000);
        MobileElement profile = driver.findElement(By.id("my_site_title_label"));
        Assert.assertTrue(profile.isDisplayed());
        //driver.quit();


    }

}
