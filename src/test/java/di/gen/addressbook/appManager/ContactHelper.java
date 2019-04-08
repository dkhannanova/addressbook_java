package di.gen.addressbook.appManager;

import di.gen.addressbook.Model.ContactAtrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactHelper extends helperBase {

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initNewContact() {
    click(By.linkText("add new"));
    }

  public void fillContact(ContactAtrs contactAtrs) {
    Fill(By.name("firstname"), contactAtrs.getName());
    Fill(By.name("lastname"), contactAtrs.getlname());
    Fill(By.name("address"), contactAtrs.getAddress());
    Fill(By.name("email"), contactAtrs.getEmail());
    Fill(By.name("home"), contactAtrs.getHomePhone());

  }

  public void submitContact() {
    click(By.name("submit"));
  }
}
