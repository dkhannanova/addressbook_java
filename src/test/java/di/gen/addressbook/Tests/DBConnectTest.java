package di.gen.addressbook.Tests;

import di.gen.addressbook.Model.ContactAtrs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DBConnectTest  {
  private SessionFactory sessionFactory;

  @BeforeClass
  public void  SetUp() {
    // A SessionFactory is set up once for an application!
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure() // configures settings from hibernate.cfg.xml
            .build();
    try {
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

    @Test
    public  void  testDBConnect(){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
    List<ContactAtrs> result = session.createQuery( "from ContactAtrs where deprecated = '0000-00-00'" ).list();

    for(ContactAtrs c:result){
      System.out.println(c);
      System.out.println(c.getGroup());}
    session.getTransaction().commit();
    session.close();

    //return new ContactAtrs(result);
  }
}
