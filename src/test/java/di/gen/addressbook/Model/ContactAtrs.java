package di.gen.addressbook.Model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactAtrs {
  @Id
  @Column(name = "id")
  private int id;
  @Column(name = "firstname")
  public String name;
  @Column(name = "lastname")
  public String lname;
  @Column(name = "address")
  @Type(type = "text")
  private String address;
  @Column(name = "email")
  @Type(type = "text")
  public String email;
  @Column(name = "photo", nullable = true)
  @Type(type = "text")
  public String photo;
  //@Transient
  //private String group;
  @Column(name = "home")
  @Type(type = "text")
  private String home;
  @Transient
  public String phone;
  @Transient
  public String mobile;
  @Transient
  public String work;
  @Transient
  private boolean creation;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  public Set<GroupAtrs> group = new HashSet<GroupAtrs>();


  public ContactAtrs() {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactAtrs that = (ContactAtrs) o;
    return id == that.id &&
            Objects.equals(name, that.name)&&
            Objects.equals(lname, that.lname);
            //Objects.equals(address.toString(), that.address.toString());
            //Objects.equals(email, that.email) &&
            // Objects.equals(photo, that.photo.toString());
            //Objects.equals(home, that.home) &&
            //Objects.equals(phone, that.phone) &&
            //Objects.equals(mobile, that.mobile)&&
            //Objects.equals(work, that.work);
            //Objects.equals(group, that.group);
  }


  @Override
  public int hashCode() {
    return Objects.hash(id, name, lname, address, email, photo, home, phone, mobile, work);
  }


  public ContactAtrs(String name, String lname, String address, String email, int id) {

    this.name = name;
    this.lname = lname;
    this.address = address;
    this.email = email;
    this.id = id;
  }

  public ContactAtrs(String name, String lname, String address, String email, File photo) {

    this.name = name;
    this.lname = lname;
    this.address = address;
    this.email = email;
    this.setPhoto(photo);
  }


  public ContactAtrs(String name, String lname) {

    this.name = name;
    this.lname = lname;
  }


  public ContactAtrs(String name, String lname, String address, String email, String group, String home, String mobile, String work, int id) {

    this.name = name;
    this.lname = lname;
    this.address = address;
    this.email = email;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.id = id;
  }

  public ContactAtrs withName(String name) {
    this.name = name;
    return this;
  }

  public ContactAtrs(String name, String lname, File photo) {

    this.name = name;
    this.lname = lname;
    this.setPhoto(photo);

  }

  public ContactAtrs withId(int id) {
    this.id = id;
    return this;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public ContactAtrs(String name, String lname, String Address, String email, String group, String phone,   /*boolean creation*/int id) {

    this.name = name;
    this.lname = lname;
    this.address = Address;
    this.email = email;
    this.phone = phone;
    //this.creation = creation;
    this.id = id;
  }

  public ContactAtrs withLname(String lname) {
    this.lname = lname;
    return this;
  }

  public ContactAtrs withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactAtrs withEmail(String email) {
    this.email = email;
    return this;
  }

  public Set<GroupAtrs> getGroup() {
    return group;
  }

  public ContactAtrs withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public ContactAtrs(String name, String lname, String Address, String email, String group, File photo, String phone, String mobile, String work, int id/*boolean creation*/) {

    this.name = name;
    this.lname = lname;
    this.address = Address;
    this.email = email;
    this.setPhoto(photo);
    this.phone = phone;
    //this.creation = creation;
    this.mobile = mobile;
    this.work = work;
    this.id = id;
  }

  public int getId() {
    return id;
  }


 /* public ContactAtrs(String name, String lname, String address, String email, int id) {
    this.name = name;
    this.lname = lname;
    this.address = address;
    this.email = email;
    this.id = 0;
  }*/


  public String getName() {
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

  public File getPhoto() {
    return new File(photo);

  }

  public ContactAtrs setPhoto(String photo) {
    this.setPhoto(new File(photo));
    return this;
  }

  @Override
  public String toString() {
    return "ContactAtrs{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lname='" + lname + '\'' +
            //", address='" + address + '\'' +
            //", email='" + email + '\'' +
            ", photo='" + photo + '\'' +
            //", home='" + home + '\'' +
            //", phone='" + phone + '\'' +
            //", mobile='" + mobile + '\'' +
            //", work='" + work + '\'' +
            ", group=" + group +
            '}';
  }

  public void setPhoto(File photo) {
    this.photo = photo.getPath();
  }

  public void setGroup(GroupAtrs group) {
    this.group.add(group);

  }
}
