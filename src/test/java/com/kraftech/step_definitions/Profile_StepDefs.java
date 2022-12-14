package com.kraftech.step_definitions;

import com.kraftech.pages.ProfilePage;
import com.kraftech.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Profile_StepDefs {
    ProfilePage profilePage = new ProfilePage();

    @When("User should go to My Profile")
    public void user_should_go_to_my_profile() {
        profilePage.myProfileBtn.click();
    }

    @When("User should navigate to {string}")
    public void user_should_navigate_to(String tabName) {
        profilePage.profileTab(tabName);
    }

    @When("User should input the information boxes")
    public void user_should_input_the_information_boxes() {
        profilePage.fullName.sendKeys("Bahar");
        profilePage.about.sendKeys("This is great work");
        profilePage.company.sendKeys("GHAN IT");

        BrowserUtils.waitForVisibility(profilePage.slider, 5);
        BrowserUtils.dragAndDropBy(profilePage.slider, 150, 0);

        Select select = new Select(profilePage.job);
        select.selectByVisibleText("SDET");

        profilePage.website.sendKeys("kraftttechnologie.com");
        profilePage.location.sendKeys("Ankara");
        profilePage.skills.sendKeys("Postman, RestAssured, API, SQL");
        BrowserUtils.clickWithJS(profilePage.save);
    }

    @Then("User should verify the profile updated message")
    public void user_should_verify_the_profile_updated_message() {

        String actualMsg = profilePage.profileUpdatemsg.getText();
        String expectedMsg = "Profile Updated";

        Assert.assertEquals(expectedMsg, actualMsg);

    }

    @Then("User should see the profile options")
    public void user_should_see_the_profile_options(List<String> Options) {


        List<String> actualOption = BrowserUtils.getElementsText(profilePage.profileOptions);
        System.out.println("actualOption.size() = " + actualOption.size());
        System.out.println("actualOption = " + actualOption);
        System.out.println("profileOptions = " + Options);
        Assert.assertEquals(Options, actualOption);

    }

}
