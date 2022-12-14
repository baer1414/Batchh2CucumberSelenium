package com.kraftech.step_definitions;

import com.kraftech.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        System.out.println("\tthis is comming from Befor Method");
        Driver.get().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        System.out.println("\tthis is comming from After Method");

        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        Driver.closeDriver();
    }


    @Before("@db")
    public void setUDb(){
        System.out.println("\t Connecting Db");
    }

    @After("@db")
    public void tearDownDb(){
        System.out.println("\t Disconnecting Db");
    }

}
