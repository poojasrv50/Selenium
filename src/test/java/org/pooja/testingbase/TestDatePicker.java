package org.pooja.testingbase;

import com.pooja.test.SeleniumLoad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;


public class TestDatePicker extends SeleniumLoad {


    @BeforeMethod
    public void selectDriver() {
        driver.get(baseurl);
        driver.manage().window().maximize();

    }

    @Test(enabled = true)
    public void selectDate() throws InterruptedException {
      MakeMyTripPage obj = new MakeMyTripPage(driver);
      obj.selectDatePicker();
    //  obj.navigateBackwardMonth();
        Date currentDate = new Date("May 12 2024");
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);
        String formattedDate = sdf.format(currentDate);
        obj.setMonthYear(formattedDate);
        String[] token = formattedDate.split(" ");
        String date = token[1];
        String month = token[0];
        String year = token[2].substring(2,4);

        Assert.assertEquals(date,obj.getSelectedDate());
        Assert.assertEquals(month,obj.getSelectedMonth());
        Assert.assertEquals(year,obj.getSelectedYear());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }


}
