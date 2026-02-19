package dev.memora.core;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseUITest {
  Playwright playwright;
  Browser browser;
  public Page page;

  @BeforeAll
  public void globalSetup(){
    playwright = Playwright.create();
    browser = playwright.chromium().launch(new BrowserType.LaunchOptions());
  }

  @BeforeEach
  public void setup(){
    page = browser.newPage();
  }

  @AfterAll
  public void globalTeardown(){
    browser.close();
    playwright.close();
  }
}