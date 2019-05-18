package di.gen.addressbook.Tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import di.gen.addressbook.Model.ContactAtrs;
import di.gen.addressbook.Model.GroupAtrs;
import di.gen.addressbook.TestBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CreateContactTest extends TestBase {


  private GroupAtrs group;

  @DataProvider
  public Iterator<Object[]> hardContacts() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.csv")));
    String line = reader.readLine();
    while (line!=null){
      String[] split =line.split(";");
      list.add(new Object[]{new ContactAtrs(split[0],split[1])});
      line = reader.readLine();
    }

     return list.iterator();
  }
  @DataProvider
  public Iterator<Object[]>contactsXml() throws IOException {
    BufferedReader reader  =new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    XStream xstream = new XStream();
    String xml="";
    String line = reader.readLine();
    while(line!=null){
      xml+=line;
      line = reader.readLine();
    }
    List<ContactAtrs> contacts = (List<ContactAtrs>) xstream.fromXML(xml);

    return contacts.stream().map((s)->new Object[]{s}).collect(Collectors.toList()).iterator();
  }

  @DataProvider
  public Iterator<Object[]>contactsJSON() throws IOException {
    BufferedReader reader  =new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json="";
    String line = reader.readLine();
    while(line!=null){
      json+=line;
      line = reader.readLine();
    }
    Gson gson  = new Gson();
    List<ContactAtrs> contacts = gson.fromJson(json, new TypeToken<List<ContactAtrs>>(){}.getType());
    return contacts.stream().map((s)->new Object[]{s}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "contactsJSON")
  public void createContact(ContactAtrs contact) throws IOException {
    app.getNavigationHelper().goToContacts();
    List<ContactAtrs> before = app.getDbhelper().contacts();
    List <GroupAtrs> groups = app.getDbhelper().groups();
    Set<GroupAtrs> groupsset = new HashSet<GroupAtrs>(groups);
    group = groupsset.iterator().next();
    app.getContactHelper().createContactMethod(contact, group);
    //app.getNavigationHelper().goToContacts();
    List<ContactAtrs> after  = app.getDbhelper().contacts();
    int max = 0;

    for (ContactAtrs c:after) {
      if (max < c.getId()) {
        max = c.getId();
      }
    }

    contact.setId(max);
    contact.setGroup(group);
    before.add(contact);
    Comparator<? super ContactAtrs> byId= Comparator.comparingInt(ContactAtrs::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
    Assert.assertEquals(before.get(before.size()-1).getGroup().toString(),after.get(after.size()-1).getGroup().toString());

    System.out.println(encoder("src/test/resources/contacts.json"));
    String[] words = (after.get(after.size()-1).getPhoto().toString()).split(":");
    System.out.println(words[1]);
    Assert.assertEquals(encoder("src/test/resources/contacts.json"), words[1]);
    System.out.println(before.get(before.size()-1).getGroup().toString());
    System.out.println(after.get(after.size()-1).getGroup().toString());
    //Assert.assertEquals(before.get(before.size()-1).getGroup().hashCode(),after.get(after.size()-1).getGroup().hashCode());
    //Assert.assertEquals(Collections.sort(before), Collections.sort(after));
    }


  public static String encoder(String filePath) {
    String base64File = "";
    File file = new File(filePath);
    try (FileInputStream imageInFile = new FileInputStream(file)) {
      // Reading a file from file system
      byte fileData[] = new byte[(int) file.length()];
      imageInFile.read(fileData);
      base64File = Base64.getEncoder().encodeToString(fileData);
    } catch (FileNotFoundException e) {
      System.out.println("File not found" + e);
    } catch (IOException ioe) {
      System.out.println("Exception while reading the file " + ioe);
    }
    return base64File;
  }
}




