package di.gen.addressbook.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import di.gen.addressbook.Model.ContactAtrs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class ContactDataGenerator {

  public static  void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);
    String format = args[2];


    List<ContactAtrs> contacts = generate(count);
    if (format.equals("csv")){
    saveasCSV(contacts, file);}
    else if (format.equals("xml")) {
    saveasXML(contacts, file);}
    else if (format.equals("json")) {
    saveasJSON(contacts,file);}
    else {
        System.out.println("Unrecognized format"+format);
      }
    }

  private static void saveasXML(List<ContactAtrs> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    XStream xstream = new XStream();
    String xml = xstream.toXML(contacts);
    writer.write(xml);
    writer.close();

  }

  private static void saveasJSON(List<ContactAtrs> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    Gson gson  = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(contacts);
    writer.write(json);
    writer.close();

  }

  private static void saveasCSV(List<ContactAtrs> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactAtrs contact: contacts){
      writer.write(String.format("%s;%s\n", contact.getName(),contact.getlname(),contact.getGroup()));
    }
  writer.close();

  }

  private static List<ContactAtrs> generate(int count) {
    List<ContactAtrs> contacts = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactAtrs(String.format("nameX %s", i), String.format("lname %s", i),new File("src/test/resources/contacts.json")));
    }

    return contacts;
  }


}