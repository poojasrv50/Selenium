package org.pooja.testingbase;

import com.pooja.test.SeleniumLoad;

//import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
//import java.io.IOException;

public class TestTakeScreen extends SeleniumLoad {
    @ BeforeClass
    public void setUp()  {
        driver.get(baseurl);
    }
    @ AfterClass
    public void tearDown() {
        driver.quit();
    }
    @ Test
    public void test() throws IOException {
        // Capture the screenshot
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Code for pasting screenshot to a user-specified location
        FileUtils.copyFile(file, new File("/Users/poojasrivastava/Downloads/src/Scr.jpg"));
    }
}
