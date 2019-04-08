package di.gen.addressbook.Tests;

import di.gen.addressbook.TestBase;
import di.gen.addressbook.Model.ContactAtrs;
import org.testng.annotations.Test;

public class CreateContactTest extends TestBase {

  @Test
  public void createContact() {
    app.getNavigationHelper().goToContacts();
    app.getContactHelper().initNewContact();
    app.getContactHelper().fillContact(new ContactAtrs("name1","lname1", "address1", "email", "42424224"));
    app.getContactHelper().submitContact();

  }

}


