package com.kraftech.step_definitions;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationMenuStepDefs {
    @When("At first get the text of dashboard")
    public void atFirstGetTheTextOfDashboard() {
        System.out.println("Dashboard");
    }

    @Then("go to Developers menu and get the text of Developer")
    public void goToDevelopersMenuAndGetTheTextOfDeveloper() {
        System.out.println("developer");
    }

    @Then("go to Edit Profile menu and get the text of Edit User Profile")
    public void goToEditProfileMenuAndGetTheTextOfEditUserProfile() {
        System.out.println("userProfile");
    }

    @When("Get the text of dashboard")
    public void getTheTextOfDashboard() {
        System.out.println("of dasbord");
    }

    @Then("go to My Profile menu and get the text of User Profile")
    public void goToMyProfileMenuAndGetTheTextOfUserProfile() {
        System.out.println("my profile");
    }
}
