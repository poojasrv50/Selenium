package org.pooja.testingbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MakeMyTripPage {

    @FindBy(xpath = "//div[@class='DayPicker-NavBar']")
    private WebElement navigation;


    @FindBy(xpath = "//div[@class='DayPicker-NavBar']/span[@class='DayPicker-NavButton DayPicker-NavButton--prev']")
    private WebElement navigateBackButton;

    @FindBy(xpath = "//div[@class='DayPicker-NavBar']/span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
    private WebElement navigateForwardButton;

    @FindBy(xpath = "//div[@class='DayPicker-Month']")
    private WebElement months;

    @FindBy(xpath = "//div[@class='flt_fsw_inputBox dates inactiveWidget ']")
    private WebElement DatePicker;

    @FindBy(xpath = "//div[@class='DayPicker-Month']/div[@class='DayPicker-Caption']/div")
    private List<WebElement> monthYear;

    @FindBy(xpath = "//div[@class='DayPicker-Day']")
    private List<WebElement> date;
    @FindBy(xpath = "//label[@for='departure']/p[1]/span[1]")
    private WebElement dateSelected;

    @FindBy(xpath = "//label[@for='departure']/p[1]/span[2]")
    private WebElement monthSelected;

    @FindBy(xpath = "//label[@for='departure']/p[1]/span[3]")
    private WebElement yearSelected;

    @FindBy(tagName = "a")
    List<WebElement> links;


    private WebDriver driver;

    public MakeMyTripPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateForwardMonth() {
        navigateForwardButton.click();
    }

    public void navigateBackwardMonth() {
        navigateBackButton.click();
    }

    public void selectDatePicker() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOf(DatePicker));
        messageElement.click();
    }

    public String getSelectedDate() {
        return dateSelected.getText();
    }

    public String getSelectedMonth() {
        return monthSelected.getText();
    }

    public String getSelectedYear() {
        return yearSelected.getText();
    }

    public void setMonthYear(String dt) throws InterruptedException {
        int count = 0;
        do {
            for (int i = 0; i < date.size(); i++) {
                if (date.get(i).getAttribute("aria-label").toString().contains(dt)) {
                    count++;
                    date.get(i).click();
                }
            }
            if (count == 0) navigateForwardMonth();

        } while (count == 0);

    }

    public List<WebElement> getAllurl(String baseUrl) {
        String url;


        Iterator<WebElement> it = links.iterator();
        List<WebElement> urls = new ArrayList<>();
        while(it.hasNext()){
          url = it.next().getAttribute("href");
          if( url == null)
          {
             // System.out.println("Url is null");
              continue;
          }
            if(!(url.startsWith(baseUrl))){
              //  System.out.println("URL belongs to another domain, skipping it.");
            } else {
                urls.add(it.next());
            }


        }
        return urls;
    }


}
