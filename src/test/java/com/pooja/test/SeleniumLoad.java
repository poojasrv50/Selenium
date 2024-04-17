package com.pooja.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SeleniumLoad {
    public static WebDriver driver = null;
    public static String baseurl = "https://www.makemytrip.com/flights/";
    public SeleniumLoad(){

        System.setProperty("webdriver.chrome.driver","/Users/poojasrivastava/Downloads/chromedriver-mac-arm64/chromedriver");
         driver = new ChromeDriver();
         driver.manage().window().maximize();
    }

    public SeleniumLoad(String browser){
        System.setProperty("webdriver.chrome.driver","/Users/poojasrivastava/Downloads/chromedriver-mac-arm64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
        driver = new ChromeDriver(options);
    }


    public static void main(String[] args) {

    }
}
