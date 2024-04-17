package org.pooja.testingbase;

import com.pooja.test.SeleniumLoad;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestUrls extends SeleniumLoad {

    @BeforeMethod
    public void selectDriver() {
      //  new SeleniumLoad("chrome");
        driver.get(baseurl);
        driver.manage().window().maximize();
    }
    @Test(enabled = false)
    public void testUrls(){
        MakeMyTripPage obj = new MakeMyTripPage(driver);
        List<WebElement> urls = obj.getAllurl(baseurl);
        HttpURLConnection huc = null;
        int responseCode = 200;
        try{
            for(WebElement url :urls){
                huc = (HttpURLConnection)(new URL(url.getAttribute("href")).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                responseCode = huc.getResponseCode();
                System.out.println("URL:"+url + " Httpcode"+responseCode);
                Assert.assertTrue(responseCode<400);
            }
        }catch (Exception e){}
    }



    @Test(enabled = true)
    public void testAllPages(){
        MakeMyTripPage obj = new MakeMyTripPage(driver);
        List<WebElement> urls = obj.getAllurl(baseurl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
      //  System.out.println(urls.get(0).getAttribute("href"));
        String parentwindow = driver.getWindowHandle();
        Iterator<WebElement> it = urls.iterator();
        int count =0;
        System.out.println(STR."sizeofurl\{urls.size()}");
        while (it.hasNext()){
            System.out.println(STR."count\{count}");
           // wait.until(ExpectedConditions.elementToBeClickable(it.next()));
            Actions actions = new Actions(driver);
            actions.contextClick(it.next()).perform();

            it.next().click();
            driver.switchTo().window(parentwindow);
            count++;
        }

        Set<String> s = driver.getWindowHandles();
        Iterator<String> it1 = s.iterator();

        while (it1.hasNext()){
          //  System.out.println(STR."count\{count}");
            String child_window=it1.next();
            if(!parentwindow.equals(child_window)){
                driver.switchTo().window(child_window);
                System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.close();
            }
            count++;

        }
        driver.switchTo().window(parentwindow);


    }
    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
