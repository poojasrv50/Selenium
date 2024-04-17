package org.pooja.testingbase;
import com.pooja.test.SeleniumLoad;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestBasic extends SeleniumLoad {


    @Test

    public void testTitle(){
        driver.get("https://skipscomm.in/");
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(),"Skips Communication");
        driver.close();

    }

}
