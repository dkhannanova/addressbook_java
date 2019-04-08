package di.gen.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends helperBase {

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void goToGroups()  {
    click(By.linkText("groups"));
  }

  public void goToContacts() {
    click(By.linkText("add new"));
  }
}
