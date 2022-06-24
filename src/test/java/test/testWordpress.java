package test;

import base.baseWordpress;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.homepageWordpress;
import pages.signInWordpress;

import static org.testng.TestRunner.PriorityWeight.priority;

public class testWordpress extends baseWordpress {

    signInWordpress SignInWordpress;
    homepageWordpress HomepageWordpress;

    @Before
    public void setUpPage(){
        SignInWordpress = new signInWordpress(driver);
        HomepageWordpress = new homepageWordpress(driver);
    }

    @Test
    public void successfullLogIn(){
        SignInWordpress.inputUsername();
        SignInWordpress.continueLogin();
        SignInWordpress.continueWithPassword();
        SignInWordpress.inputPassword();
        SignInWordpress.clickLogin();
        Assert.assertTrue(HomepageWordpress.profile.isDisplayed());

    }

}
