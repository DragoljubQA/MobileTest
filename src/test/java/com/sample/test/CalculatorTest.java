package com.sample.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {

    //Ovo je test na fizicki uredjaj koji je prikacen na PC, potrebno je odobriti USB debugging
    //USB debug se odobrava iz developer options
    @Test
    public void openApp() throws MalformedURLException, InterruptedException {
        AppiumDriver<MobileElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //ove naredne dve linije dobijamo iz cmd, prvo otvorimo cmd, zatim otkljucamo fizicki uredjaj koji je prikacen
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.sec.android.app.popupcalculator");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.sec.android.app.popupcalculator.Calculator");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(5000);
        driver.quit();


    }

}
