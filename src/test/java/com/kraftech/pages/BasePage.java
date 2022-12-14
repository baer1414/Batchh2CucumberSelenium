package com.kraftech.pages;

import com.kraftech.utilities.BrowserUtils;
import com.kraftech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }


    public String getHomeName(String homeName){
        BrowserUtils.waitFor(1);
        return Driver.get().findElement(By.xpath("//li[text()='"+homeName+"']")).getText();
    }

    public void naviagateToTab(String tabName){
        driver=Driver.get();
        driver.findElement(By.xpath("//nav//span[.='"+tabName+"']")).click();

    }


    public void navigateToModule(String tab, String module){
        String tabLocator="//span[.='"+tab+"']";
        String moduleLocator="//span[.='"+module+"']";

        BrowserUtils.waitForClickablility(By.xpath(tabLocator),5);

        WebElement tabelement=Driver.get().findElement(By.xpath(tabLocator));
        tabelement.click();

        BrowserUtils.waitForClickablility(By.xpath(moduleLocator),5);

        Driver.get().findElement(By.xpath(moduleLocator)).click();

    }
    public String subTitle(String subTitle){
        String subTitleLocator="//h1[.='"+subTitle+"']";
        BrowserUtils.waitForPresenceOfElement(By.xpath(subTitleLocator),5);

        WebElement SubTitle=Driver.get().findElement(By.xpath(subTitleLocator));
        String actualSubTitle=SubTitle.getText();
        return actualSubTitle;

    }

    public String getAccountName_mtd(String accountName){
        return Driver.get().findElement(By.xpath("//span[.='"+accountName+"']")).getText();
    }



}

