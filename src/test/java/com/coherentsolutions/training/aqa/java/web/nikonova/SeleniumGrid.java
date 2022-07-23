package com.coherentsolutions.training.aqa.java.web.nikonova;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SeleniumGrid {

    @Parameters({"browserType"})
    @Test
    public void gridNodesTest(String browserType) throws MalformedURLException {
        DesiredCapabilities dr = null;
        if (browserType.equals("firefox")) {
            dr = DesiredCapabilities.firefox();
            dr.setBrowserName("firefox");
            dr.setPlatform(Platform.ANY);

        } else {
            dr = DesiredCapabilities.chrome();
            dr.setBrowserName("chrome");
            dr.setPlatform(Platform.WINDOWS);
        }

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dr);
        driver.navigate().to("http://gmail.com");
        driver.findElement(By.id("logo"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.close();

    }
}





