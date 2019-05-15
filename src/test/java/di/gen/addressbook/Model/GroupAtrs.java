package di.gen.addressbook.Model;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "group_list")
public class GroupAtrs {
  @Id
  @Column(name = "group_id")
  public int id;
  @Column(name = "group_name")
  private  String name;
  @Column (name = "group_header")
  @Type(type = "text")
  private  String header;
  @Column(name = "group_footer")
  @Type(type = "text")
  private String footer;
  @ManyToMany(mappedBy = "group", fetch = FetchType.EAGER)
  private Set<ContactAtrs> contact = new HashSet<ContactAtrs>();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupAtrs groupAtrs = (GroupAtrs) o;
    return id == groupAtrs.id &&
            Objects.equals(name, groupAtrs.name) &&
            Objects.equals(header, groupAtrs.header) &&
            Objects.equals(footer, groupAtrs.footer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, header, footer, contact);
  }

  @Override
  public String toString() {
    return "GroupAtrs{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", header='" + header + '\'' +
            ", footer='" + footer + '\'' +
            '}';
  }



  public GroupAtrs(){}

  public Set<ContactAtrs> getContact() {
    return contact;
  }

  public Set<ContactAtrs> setContact(Set<ContactAtrs> contact) {
    this.contact = contact;
    return contact;
  }

  public GroupAtrs(String name, String Header, String Footer) {
    this.name = name;
    header = Header;
    footer = Footer;
  }

  public Integer getId() {
    return id;
  }

  public GroupAtrs(String Name, String Header, String Footer, Integer id) {
    this.name = Name;
    this.header = Header;
    this.footer = Footer;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

}
