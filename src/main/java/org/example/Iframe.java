package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class Iframe {



    public static void main(String[] args) {
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
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://omayo.blogspot.com/");

        String title = driver.getTitle();

        System.out.println(title);



       driver.switchTo().frame("iframe1");

System.out.println("inside frame");
       driver.findElement(By.xpath("//a[@href='https://plus.google.com/100812711311397735125']\n")).click();



//driver.switchTo().defaultContent();
        driver.switchTo().parentFrame();

String title1 = driver.getTitle();

System.out.println(title1);





    }
}
