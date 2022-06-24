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

public class WhatsappTest {

    @Test
    public void openApp() throws MalformedURLException, InterruptedException {
        AppiumDriver<MobileElement> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.whatsapp");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.whatsapp.Conversation");
        //capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        //failuje kada pokusam sa NO_RESET
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(5000);
        driver.quit();


    }

}
