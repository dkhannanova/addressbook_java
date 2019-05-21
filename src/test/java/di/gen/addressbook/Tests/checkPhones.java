package di.gen.addressbook.Tests;

import di.gen.addressbook.Model.ContactAtrs;
import di.gen.addressbook.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

public class checkPhones extends TestBase {

@Test
  public void testCheckPhones()
  {
    app.getNavigationHelper().goToContacts();
    ContactAtrs contact = (ContactAtrs) app.getContactHelper().all().iterator().next();
    int id = contact.getId();
    ContactAtrs phoneInfoFromEdit = app.getContactHelper().infoFromEditPage(id);
    Assert.assertEquals(contact.phone, mergePhones(phoneInfoFromEdit));

  }

  private String mergePhones(ContactAtrs contact) {
    return  Arrays.asList(contact.phone, contact.mobile, contact.work)
            .stream().filter((s)->!s.equals(""))
            .map(checkPhones::clean)
            .collect(Collectors.joining("\n"));
  }

 public static String clean(String phones){
    return phones.replaceAll("\\s","").replaceAll("-[()]]","");
 }

}
