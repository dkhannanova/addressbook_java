package di.gen.addressbook.appManager;

import di.gen.addressbook.Model.ContactAtrs;
import di.gen.addressbook.Model.GroupAtrs;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;


public class DBHelper {
  private SessionFactory sessionFactory;

    public  DBHelper() {
      // A SessionFactory is set up once for an application!
      final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
              .configure() // configures settings from hibernate.cfg.xml
              .build();
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    }


  public List<ContactAtrs> contacts() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<ContactAtrs> result = session.createQuery("from ContactAtrs  where deprecated='0000-00-00'").list();
    session.getTransaction().commit();
    session.close();
    return (result);
  }

  public List<GroupAtrs> groups() {
    Session session1 = sessionFactory.openSession();
    session1.beginTransaction();
    List<GroupAtrs> result = session1.createQuery("from GroupAtrs where deprecated='0000-00-00'").list();
    session1.getTransaction().commit();
    session1.close();
    return (result);
  }



}
