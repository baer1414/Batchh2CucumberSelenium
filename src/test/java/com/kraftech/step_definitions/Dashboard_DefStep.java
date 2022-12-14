package com.kraftech.step_definitions;

import com.kraftech.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Dashboard_DefStep {
DashboardPage dashboardPage=new DashboardPage();

    @Then("The user name should be {string}")
    public void the_user_name_should_be(String excepName) {
      String actualName=dashboardPage.getUserName();
        System.out.println("actualName = " + actualName);
        System.out.println("excepName = " + excepName);
        Assert.assertEquals("Verify that name is match",excepName,actualName);
    }

    @When("The user navigates to {string} menu")
    public void the_user_navigates_to_menu(String tabName) {
        dashboardPage.naviagateToTab(tabName);
    }
    @Then("The user should be able to see home name as {string}")
    public void the_user_should_be_able_to_see_home_name_as(String expectedHomeName) {
        String actualHomeName = dashboardPage.getHomeName(expectedHomeName);
        Assert.assertEquals("Verify that home name is displayed",expectedHomeName,actualHomeName);

    }
}
