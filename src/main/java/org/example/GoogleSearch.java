package org.example;




import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class GoogleSearch {


    public static void main(String[] args) {



        try {
            // Execute the rm -rf command to clear the cache
            Process process = new ProcessBuilder("rm", "-rf", "~/.cache/selenium/chromedriver/").start();
            process.waitFor(); // Wait for the command to complete
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Initialize WebDriverManager to automatically download and set up the ChromeDriver
        WebDriverManager.chromedriver().setup(); /// No need to manually set path for chromedriver

        // Initialize Chrome options
        ChromeOptions options = new ChromeOptions();

      //  options.addArguments("--incognito");
        options.addArguments("--start-maximized"); // Start browser maximized
       // options.addArguments("--headless"); // Optionally run in headless mode (no UI)

        // Initialize ChromeDriver (WebDriver for Chrome)
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.google.com");

// Send the keyword to the search box
        driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")).sendKeys("selenium");

// Wait for the suggestions list to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

// Adjust the XPath to target the suggestions (make sure this matches the current HTML structure)
        List<WebElement> l = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='erkvQe']//ul[@role='listbox']//li//span[contains(text(), 'se')]")));





        System.out.println(l.size());



        }
    }

