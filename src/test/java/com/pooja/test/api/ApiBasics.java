package com.pooja.test.api;

import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public class ApiBasics {

    @Test
    public void getCall(){
        String url = "https://makemytrip.com";
        var response = given().header("Content-Type","application/json" ).when().get(url).then();
       System.out.println(response.log().body());
       // XmlPath xmlPath = response.xmlPath();

        // Convert XML to JSON

        XmlPath xmlPath = response.extract().xmlPath();
        String jsonResponse = xmlPath.prettify();
        //String value1 = xmlPath.getString("//div[@id='mngb']");
        System.out.println(jsonResponse);
    }

}
