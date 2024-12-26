package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {

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

        // Navigate to the URL
        driver.get("https://www.thehindu.com/");

        // Find all <a> tags (links) on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Found " + links.size() + " links on the page.");

        List<String> urllist = new ArrayList<>();

        // Collect all URLs from the page
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) {  // Ensure the URL is not null or empty
                urllist.add(url);
            }
        }

        // Start timing the broken link checks
        long starttime = System.currentTimeMillis();

        // Check the URLs in parallel for broken links
        urllist.stream().forEach(e -> checkBrokenLink(e));

        long endtime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endtime - starttime) + " milliseconds");

        // Close the browser after execution
        driver.quit();
    }

    /**
     * Checks whether the given URL is broken by sending an HTTP request and
     * verifying the response code.
     *
     * @param url the URL to check
     */
    public static void checkBrokenLink(String url) {
        try {
            // Create a URL object
            URL u = new URL(url);

            // Open an HTTP connection to the URL
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setConnectTimeout(5000);  // Set a 5-second timeout for the connection
            connection.connect();

            // Check if the response code indicates a broken link (HTTP 4xx or 5xx)
            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                System.out.println(responseCode + " " + connection.getResponseMessage() + " - " + u + " is a broken link");
            } else {
                System.out.println(responseCode + " " + connection.getResponseMessage() + " - " + u + " is a valid link");
            }

        } catch (IOException e) {
            System.out.println("Error checking URL: " + url);
            e.printStackTrace();  // Log exception for debugging
        }
    }
}
