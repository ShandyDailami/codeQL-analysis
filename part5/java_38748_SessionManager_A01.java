import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_38748_SessionManager_A01 {
   public static void main(String[] args) {
      // Create session factory
      SessionFactory factory = new Configuration().configure().buildSessionFactory();

      // Create session
      Session session = factory.openSession();

      // Start transaction
      session.beginTransaction();

      // Execute a simple insert operation
      session.save(new Student(1, "John"));
      session.save(new Student(2, "David"));

      // Commit the transaction
      session.getTransaction().commit();

      // Close session
      session.close();
   }
}

class Student {
   private int id;
   private String name;

   public java_38748_SessionManager_A01(int id, String name) {
      this.id = id;
      this.name = name;
   }

   // getters and setters
}