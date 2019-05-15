package di.gen.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends helperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroups()  {

    if(isElementPresent(By.tagName("h1"))&& isElementPresent(By.name("new")))
    {return;}
    click(By.linkText("groups"));
  }

  public void goToContacts() {
    if (isElementPresent(By.id("maintable"))&& (isElementPresent(By.xpath("//input[@value='Delete']"))))
    {return;}
    click(By.linkText("home"));
  }
}
