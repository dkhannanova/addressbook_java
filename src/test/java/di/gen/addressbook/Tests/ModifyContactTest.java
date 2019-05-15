package di.gen.addressbook.Tests;

import di.gen.addressbook.Model.ContactAtrs;
import di.gen.addressbook.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class ModifyContactTest extends TestBase {

  @BeforeMethod
  public List<ContactAtrs> assurePreconditions(){
  app.getNavigationHelper().goToContacts();
  List <ContactAtrs> before = app.getDbhelper().contacts();
  //List<ContactAtrs> before = app.getContactHelper().getContacttList();
  ContactAtrs contact=new ContactAtrs(null,null, null,"2121212",null,null, null, null,  0);
  if  (before.size()==0){
  app.getContactHelper().createContactMethod(contact,null);
  }
   return before;
  }


  @Test
  public void createContact() {
    int id = assurePreconditions().get(assurePreconditions().size() - 2).getId();
    ContactAtrs contact = new ContactAtrs("oops","lnamemod1", "address1", "email", "java1", new File("src/test/resources/IMG_4479.JPG"), "1223","12","123", id);
    app.getContactHelper().editContact(id);
    app.getContactHelper().fillContact((contact), null,false);
    app.getContactHelper().updateContact();
    app.getNavigationHelper().goToContacts();
    List<ContactAtrs> after = app.getDbhelper().contacts();
    //List<ContactAtrs> after  = app.getContactHelper().getContacttList();
    assurePreconditions().remove(assurePreconditions().size()-1);
    assurePreconditions().add(contact);
    Assert.assertEquals(assurePreconditions(), after);


  }

}

