package di.gen.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class helperBase {
  public WebDriver driver;

  public helperBase(WebDriver driver) {
    this.driver = driver;
  }

  protected void Fill(By locator, String text) {
    if (text!=null)
    {driver.findElement(locator).click();
    driver.findElement(locator).clear();
    driver.findElement(locator).sendKeys(text);}
  }


  protected void attach(By locator, File file) {
    if (file!=null)
    {
      driver.findElement(locator).sendKeys(file.getAbsolutePath());
    }
  }

  public void click(By locator){
    driver.findElement(locator).click();
  }

  public boolean isElementPresent(By locator)
  {
    try{
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex){
      return false;}
  }


}
