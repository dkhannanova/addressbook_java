package di.gen.addressbook.Model;

public class ContactAtrs {
  public String name;
  public String lname;
  private String address;
  public  String email;
  public String phone;



  public  ContactAtrs(String name, String lname, String Address, String email, String phone) {

    this.name = name;
    this.lname = lname;
    this.address = Address;
    this.email = email;
    this.phone = phone;
  }

  public  String getName() {
    return name;
  }

  public String getlname() {
    return lname;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public String getHomePhone() {
    return phone;
  }
}
