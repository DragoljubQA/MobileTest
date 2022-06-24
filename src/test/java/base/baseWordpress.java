package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class baseWordpress {

    public static AppiumDriver<MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/WordPress.apk");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.accounts.SignInActivity");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"android");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        Thread.sleep(5000);
    }

    @After
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }
}
