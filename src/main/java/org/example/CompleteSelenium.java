package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CompleteSelenium {




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
        driver.manage().window().maximize();// maximise window
        driver.manage().deleteAllCookies(); // delete cookies
        driver.manage().window().fullscreen();

        driver.manage().window().getSize();

        driver.manage().window().setSize(new Dimension(1920, 1080));


        driver.get("https://omayo.blogspot.com/");

        String title = driver.getTitle();

        System.out.println(title);

       String cu =  driver.getCurrentUrl();

System.out.println(cu);


driver.findElement(By.id("tal")).sendKeys("test");

//driver.findElement(By.id(tal)).sendKeys(Keys.ENTER);

//        driver.findElement(By.id(tal)).sendKeys(Keys.CONTROL + "a");
//
//        driver.findElement(By.id(tal)).sendKeys(Keys.CONTROL + "x");
//
//        driver.findElement(By.id(tal)).sendKeys(Keys.CONTROL + "v");








//
//
////way 1 :
//  //   driver.findElement(By.xpath("//*[@id=\"ta1\"]")).sendKeys("kranthi");
////way2  :
//
//      WebElement d2 =   driver.findElement(By.xpath("//*[@id=\"ta1\"]"));
//d2.sendKeys("kranthi");
//d2.clear();
//
////way 3 :
//        WebElement d3= driver.findElement(By.xpath("//*[@id=\"ta1\"]"));
//        Actions actions = new Actions(driver);
//        actions.sendKeys(d3, "kranthi").perform();
//
////way 4:
//        WebElement d4 = driver.findElement(By.xpath("//*[@id=\"ta1\"]"));
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='kranthi';", d4);
//
//
//        //way 5:
//        WebElement d5 = driver.findElement(By.xpath("//*[@id=\"ta1\"]"));
//        d5.sendKeys("kranthi");
//        d5.sendKeys(Keys.ENTER);  // Simulate pressing Enter key
//
//
////        Way 6: Sending Multiple Key Strokes (Simulate key combinations)
//
//        WebElement d6 = driver.findElement(By.xpath("//*[@id=\"ta1\"]"));
//        d6.sendKeys("kranthi" + Keys.TAB);  // Send text and then simulate Tab key
//
//
//
//
//        //login button clicked error message
 //driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[3]")).click();
//
//       // driver.findElement(By.linkText("compendiumdev")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[1]")).sendKeys("a");
//
//        driver.findElement(By.xpath("//*[@id=\"HTML42\"]/div[1]/form/input[2]")).sendKeys("b");
//
//
//        driver.findElement(By.xpath("//input[@value='Login']")).sendKeys(Keys.ENTER);

        // sendkeys enter , click , submit - three ways to submit
//
//
//        driver.findElement(By.partialLinkText("matedtester")).click();




        //  driver.findElement(By.xpath("//*[@id=\"pah\"]")).getText();

       // driver.quit(); // will close all the browser windows that are currently opened


//        // Find the link element
//        WebElement x = driver.findElement(By.linkText("Open a popup window"));
//
//
//      x.click();
//
//
//      driver.findElement(By.xpath("//*[@id=\"BlogSearch1_form\"]/form/table/tbody/tr/td[2]/input")).getAttribute("value");


//       driver.findElement(By.xpath("//*[@id=\"BlogSearch1_form\"]/form/table/tbody/tr/td[2]/input")).isDisplayed();
//
//        driver.findElement(By.xpath("//*[@id=\"BlogSearch1_form\"]/form/table/tbody/tr/td[2]/input")).isEnabled();
//
//
//       //usually used for checkboxes
//        driver.findElement(By.xpath("//*[@id=\"BlogSearch1_form\"]/form/table/tbody/tr/td[2]/input")).isSelected();
//
//
//


        WebElement element = driver.findElement(By.xpath("//*[@id=\"HTML11\"]/div[1]/textarea"));


        File screenshot = element.getScreenshotAs(OutputType.FILE);

        // Define the destination file path with the file name (e.g., screenshot.png)
        File destinationFile = new File("/Users/kranthi/Downloads/SeleniumAutomation/target/screenshots/elementScreenshot.png");

        try {
            // Copy the screenshot to the destination
            FileHandler.copy(screenshot, destinationFile);
            System.out.println("Screenshot saved at: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to save the screenshot.");
        }



       System.out.println( driver.getPageSource());


        driver.navigate().refresh();

        driver.navigate().forward();

        driver.navigate().back();
        driver.navigate().to("https://omayo.blogspot.com/");

            driver.findElement(By.xpath("//*[@id=\"BlogSearch1_form\"]/form/table/tbody/tr/td[2]/input")).getTagName();



    //     -- using dimesion class   //getSize -- to find the location of the particular text box
   // -- using point class     //getLocation  -- text box , button , possiton of element - to find x - y coordinate




        //xpath , findelements , tagname ,


        //getcssvalue  ---- find element then go to styles give property key in get css value memnthod


        //getclass

        //driver.getClass().getSimpleName() ; writeen in string we can print out



        // for dropdowns -- select class

        //first find the dropdown xpath then pass to select class constructor
        //Select s = new Select ()
        //s.selectByVisibleText("");


        //select by index

        //s.selectByindex(0);
        //s.selectByValue("");



        //ismultiple -- for a dropdown -if we pass this it will tell boolean , t or f

        //find the element of dropdown -> find the elements of dropdowns

      // dropdownfeild

           //     multiselectboxfeild

        //select s = new Select(dropdownfeild);

      //  s.ismultiplem--- print cosole




//getOptions --- for dropdown feild we can pull all options coming like example : class create course page
        //1. find dropdown -> pass it to select class class -> select.getoptions store in llist and print it


        //getFirstSelectedoption for multi select dropdown -> in dropdown what order the values there it will take the first one as this method



        //getAllSelectedOption  -- from dropdown -> how many are selected  will be printed

        //find dropdown -> pass it to select -> then selct.selectByVisibleText
        // then select.getAllSelectedOption



        //deSelectByVisibleText --same but -> select.deselectByVisibleText ,,deselectByIndex,deSelectByValue,deSelectAll



        //frame -- switchTo frame using weblement , using index, using name or id

        //parentframe , default content


        // parentframe --> inner iframe -> we can give index for the frame  first identify parent and go inside inner frame using index


        //driver.manage.timeouts.pageloadtimeout(4,unit)



        //driver.manage.timeouts.setscripttimeout(10,TimeUnit.seconds)


        //delayed button -dropdown

        //taking 3 or 5 secods it is enabled and coming in this sceanrio it will need implicit wait

        // driver.manage.timeouts.implicitlyWait(10, TimeUnit.SECONDS);  // FOR GLOBAL ALL WEBELEMENTS





        //EXPLICIT WAIT

        // FOR ONLY SPECIFIC WEBELEMENT

//WebDriverWait wait = new WebDriverWait(driver,10);
//
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy())
//        wait.until(ExpectedConditions.invisibilityOfElementLocated( pass the xpath of the element




        //after 10 secxonds check box enablesd

//        wait.until(ExpectedConditions.elementToBeClickable();
//
//        wait.until(ExpectedConditions.elementToBeSelected()   , alertisPresent
//
//                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(

        //invisibilityofElement -- basically the element txt will disapper after some seconds

        //Alert alert = driver.switchTo().alert();

        //alert.getText, alert.accept,alert.dismiss
        //find click on button , you wll get alert than use explicit wait webdriverwait untill ecpected conditions alertisPresent
        //alert.sendkeys

        //find the webelement ex: blogs  , create local vaiables pass it to move to element

        //Actions actions = new Actions(driver)

        //actions.moveToelement(variable)build.perform

        //clicktogetalert using mouse

        //find the element store in variable
        //use actions class  , then actions.movetoelement (variable) .click.build.perfrom


        // actions.draganddropby(variable,postion).build.perfrom


        //actions.contextclick(variable).build.perfrom

        //actions.doubleclick(variable).build.perfrom



        //webelement variable1 and variable 2
        //actions.draganddrop(x,y).build.perform


//actions.movetoelement(variable).keyDown(keys.CAONTROL).CLICK.keysup(keys.cpntrol).build.perform






















        //


        driver.close();  // will close only current browser window

    }
}
