package di.gen.addressbook.appManager;

import di.gen.addressbook.Model.ContactAtrs;
import di.gen.addressbook.Model.GroupAtrs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.*;

public class ContactHelper<id, contact> extends helperBase {

  private int index;
  private int id;
  private ContactAtrs contact;

  public ContactHelper(WebDriver driver) {
    super(driver);
  }

  public void initNewContact() {
    click(By.linkText("add new"));
    }

  public void fillContact(ContactAtrs contactAtrs, GroupAtrs group, boolean creation) {
    Fill(By.name("firstname"), contactAtrs.getName());
    Fill(By.name("lastname"), contactAtrs.getlname());
    Fill(By.name("address"), contactAtrs.getAddress());
    Fill(By.name("email"), contactAtrs.getEmail());
    Fill(By.name("home"), contactAtrs.getHomePhone());
    Fill(By.name("mobile"), contactAtrs.getMobile());
    Fill(By.name("work"), contactAtrs.getWork());
    attach(By.name("photo"), contactAtrs.getPhoto() );

    if (creation)
    {
      new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(group.getName());
    }
      else
    {
      Assert.assertFalse(isElementPresent(By.name("new_group")));}
  }

  public void submitContact() {
    click(By.name("submit"));
  }



  public void editContact(int index) {
  driver.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", index))).click();
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public List<ContactAtrs> getContacttList() {
    List<ContactAtrs> contacts = new ArrayList<ContactAtrs>();
    List <WebElement> elements  = driver.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String email = element.findElement(By.tagName("a")).getText();
      String phones = element.findElement(By.xpath(".//td[6]")).getText();

      ContactAtrs contact = new ContactAtrs(name, lname,address,email,id);
      contacts.add(contact);

      }



      return contacts;
  }

  public Set<ContactAtrs> all() {
    Set<ContactAtrs> contacts = new HashSet<>();
    List <WebElement> elements  = driver.findElements(By.name("entry"));
    for (WebElement element : elements) {
      String lname = element.findElement(By.xpath(".//td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      String name = element.findElement(By.xpath(".//td[3]")).getText();
      String address = element.findElement(By.xpath(".//td[4]")).getText();
      String email = element.findElement(By.tagName("a")).getText();
      String phones = element.findElement(By.xpath(".//td[6]")).getText();
      ContactAtrs contact  = new ContactAtrs(name, lname, address, email, null, phones,id);
      contacts.add(contact);
      }

    return contacts;
  }

  public Object createContactMethod(ContactAtrs contact, GroupAtrs group) {
    initNewContact();
    //ContactAtrs contact = new ContactAtrs("name1","lname1", "address1", "email", "java1","111");
    fillContact(contact, group, true);
    submitContact();
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactHelper<?, ?> that = (ContactHelper<?, ?>) o;
    return index == that.index &&
            id == that.id &&
            Objects.equals(contact, that.contact);
  }

  @Override
  public int hashCode() {
    return Objects.hash(index, id, contact);
  }

  public ContactAtrs infoFromEditPage(int id){
    editContact(id);
    String home = driver.findElement(By.xpath("//input[@name='home']")).getAttribute("value");
    String mobile = driver.findElement(By.xpath("//input[@name='mobile']")).getAttribute("value");
    String work = driver.findElement(By.xpath("//input[@name='work']")).getAttribute("value");
    ContactAtrs ContactPhones = new ContactAtrs(null,null, null,"2121212",null,home, mobile, work,  0);
  return ContactPhones;
  }

  public String fromFileToString(File file){
    return file.getPath();

  };


}
