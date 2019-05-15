package di.gen.addressbook.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  private final Properties properties;
  public WebDriver driver;
  public   NavigationHelper navigationHelper;
  private  GroupHelper groupHelper;
  private SessionHelper sessionHelper;
  private ContactHelper contactHelper ;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private String browser;
  private DBHelper dbhelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }


  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));
    //driver.get(properties.getProperty("webBaseUrl"));
    dbhelper = new DBHelper();

    if (browser.equals(BrowserType.FIREFOX))
    {driver = new FirefoxDriver();}
        else if(browser.equals(BrowserType.CHROME))
        {driver = new ChromeDriver();    }
          else if(browser.equals(BrowserType.IE))
          {driver = new InternetExplorerDriver();    }


    baseUrl = properties.getProperty("webBaseUrl");
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    groupHelper = new GroupHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    sessionHelper = new SessionHelper(driver);
    contactHelper = new ContactHelper(driver);
    sessionHelper.login(properties.getProperty("webAdmin"),properties.getProperty("webPassword"));

  }


  public void stop() {
    driver.quit();
  }

  public boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  public String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public ContactHelper getContactHelper() {return contactHelper;}

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public DBHelper getDbhelper(){
    return dbhelper;
  }


}
