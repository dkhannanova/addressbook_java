package di.gen.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends helperBase {

  public SessionHelper(WebDriver driver) {
    super(driver);
  }

  public void login(String username, String password) {
    driver.get("http://localhost/addressbook/");
    Fill(By.name("user"), username);
    Fill(By.name("pass"), password);
    clickButton(By.id("LoginForm"));
  }

  private void clickButton(By locator) {
    driver.findElement(locator).submit();
  }
}
