package di.gen.addressbook.appManager;

import di.gen.addressbook.Model.GroupAtrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupHelper extends helperBase {

  public GroupHelper(WebDriver driver) {
    super(driver);
   }

  public void submitNewGroup() {
    click(By.name("submit"));
  }

  public void fillGroup(GroupAtrs groupAtrs) {
    Fill(By.name("group_name"), groupAtrs.getName());
    Fill(By.name("group_header"), groupAtrs.getHeader());
    Fill(By.name("group_footer"), groupAtrs.getFooter());
  }


  public void initiateNewGroup() {

    click(By.name("new"));
  }

  public void deleteSelected() {

    click(By.name("delete"));
  }

  public void selectGroup() {

    click(By.name("selected[]"));
  }
}
