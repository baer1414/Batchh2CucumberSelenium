package com.kraftech.step_definitions;

import com.kraftech.pages.DashboardPage;
import com.kraftech.pages.LoginPages;
import com.kraftech.utilities.BrowserUtils;
import com.kraftech.utilities.ConfigurationReader;
import com.kraftech.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class Login_StepDefs {
    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();


    @Given("The  user is on the login page")
    public void the_user_is_on_the_login_page() {

        System.out.println("Batch2 was here");
        System.out.println("I open the browser and nagitive to kraft tech web page");

    }
    @When("The user enters Coday credentials")
    public void the_user_enters_coday_credentials() {
        System.out.println("I enter coday username and password and click login buton");

    }
    @Then("The user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("I verift that changed Dasboard page");
    }

    @When("The user enters Sebestian credentials")
    public void theUserEntersSebestianCredentials() {

        System.out.println("I enter Sebestian username and password and click login buton");
    }

    @When("The user enters Jhon Nash credentials")
    public void theUserEntersJhonNashCredentials() {

        System.out.println("I enter Jhon Nash username and password and click login buton");
    }
    @When("The user enters Rosa credentials")
    public void the_user_enters_rosa_credentials() {
        System.out.println("I enter Rosa username and password and click login buton");
    }

    @Given("User should be on the login page")
    public void user_should_be_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));

    }
    @When("User should input login information")
    public void user_should_input_login_information() {
        loginPages.loginUser();

    }
    @Then("User should be on home page")
    public void user_should_be_on_home_page() {
        BrowserUtils.waitFor(3);
        String actualTitle=Driver.get().getTitle();

        Assert.assertEquals("verify Title","Dashboard - Kraft Techex Lab - aFm",actualTitle);
        System.out.println("actualTitle = " + actualTitle);
    }


    @When("When User should input {string} and {string}")
    public void whenUserShouldInputAnd(String email, String password) {
        loginPages.loginWithParameters(email,password);

    }


    @Then("User should input following credentials")
    public void user_should_input_following_credentials(Map<String,String>userInfo) {
      loginPages.loginWithParameters(userInfo.get("email"),userInfo.get("password"));

      String actualName=dashboardPage.getUserName();
      String expectedName=userInfo.get("Name");

        System.out.println("actualName = " + actualName);
        System.out.println("expectedName = " + expectedName);

        Assert.assertEquals(expectedName,actualName);


    }


    @Then("The warning message contains {string}")
    public void the_warning_message_contains(String expectedWarningMessage) {
        BrowserUtils.waitFor(1);
        String actualWarningMessage = loginPages.getWarningMessageText(expectedWarningMessage);
        Assert.assertEquals(expectedWarningMessage,actualWarningMessage);
    }

}
