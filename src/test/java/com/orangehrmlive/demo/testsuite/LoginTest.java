package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();
    }

    @Test(groups = {"sanity"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
    }

    @Test(groups = {"sanity", "smoke"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        Assert.assertEquals(homePage.verifyUserProfileIsDisplayed(), true);
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        loginPage.enterUserNameAndPasswordForLogin("Admin", "admin123");
        dashboardPage.clickOnUserProfileImage();
        dashboardPage.mouseHoverOnLogOutLinkAndClick();
    }

}
