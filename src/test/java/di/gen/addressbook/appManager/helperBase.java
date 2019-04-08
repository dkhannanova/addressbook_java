package di.gen.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

  public void click(By locator){
    driver.findElement(locator).click();
  }
}
