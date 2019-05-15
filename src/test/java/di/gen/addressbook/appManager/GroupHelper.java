package di.gen.addressbook.appManager;

import di.gen.addressbook.Model.GroupAtrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends helperBase {
  public   NavigationHelper navigationHelper;


  List groups;

  public GroupHelper(WebDriver driver) {

    super(driver); }

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

  public void selectGroup(int index) {
    driver.findElements(By.name("selected[]")).get(index).click();
  }

  public int getGroupCount() {
    return driver.findElements(By.name("selected[]")).size();
  }

  public void createGroup(GroupAtrs group) {
    initiateNewGroup();
    fillGroup(group);
    submitNewGroup();}

  public List<GroupAtrs> getGroupList() {
    List<GroupAtrs>  groups = new ArrayList<GroupAtrs>();
    List<WebElement> elements = driver.findElements(By.cssSelector("span.group"));
    for (WebElement element:  elements){
      String name = element.getText();
      String  id = element.findElement(By.tagName("input")).getAttribute("value");
      GroupAtrs group = new GroupAtrs(name, null, null, Integer.parseInt(id));
      groups.add(group);
    }
    System.out.println(("elements count")+groups.size());
    return groups;
  }
}
