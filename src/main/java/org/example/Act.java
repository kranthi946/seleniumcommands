package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Act {




    public static void main(String[] args) throws InterruptedException {
        // Clear any previous ChromeDriver cache
        try {
            Process process = new ProcessBuilder("rm", "-rf", "~/.cache/selenium/chromedriver/").start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Set up WebDriverManager and ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Set Chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();// maximise window
        driver.manage().deleteAllCookies(); // delete cookies
        driver.manage().window().fullscreen();

        driver.manage().window().getSize();

        driver.manage().window().setSize(new Dimension(1920, 1080));


        //   driver.get("https://www.amazon.in/ref=nav_logo");


   //driver.get("https://joltfly.com/double-click-test/");
driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");




WebElement drag = driver.findElement(By.id("draggable"));

WebElement drop = driver.findElement(By.id("droptarget"));


WebElement sb = driver.findElement(By.className("kd-input"));



        Actions a = new Actions(driver);


        Thread.sleep(3000);
      //  a.dragAndDrop(drag, drop).build().perform();

       // a.moveToElement(driver.findElement(By.id("nav-link-amazonprime"))).perform();

//a.clickAndHold(drag).moveToElement(drop).release().build().perform();

       // a.contextClick().perform();

       // a.contextClick(driver.findElement(By.id("nav-link-amazonprime"))).perform();



      //  a.doubleClick(driver.findElement(By.id("startbutton"))).perform();




   //     a.keyDown(sb , Keys.SHIFT).sendKeys("iphone").build().perform();
        a.keyDown(sb , Keys.SHIFT).sendKeys("iphone ").keyUp(Keys.SHIFT).sendKeys("kranthi").build().perform();

        Thread.sleep(3000);
                 driver.quit();
    }



}