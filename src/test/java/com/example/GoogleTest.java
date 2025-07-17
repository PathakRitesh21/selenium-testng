package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    @Test
    public void openGoogle() {
    	WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
