import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_09869_SessionManager_A08 {
    private static SessionFactory sessionFactory;  

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {  
            try {  
                sessionFactory = new Configuration().configure().buildSessionFactory();  
            }  
            catch (Throwable ex) {  
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }  
        }  
        return sessionFactory;  
    }  

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {
        Session session = openSession();

        // Perform CRUD operations here
        // For example, save an entity
        session.beginTransaction();
        // Assuming we have an entity named "Employee" with fields "id" and "name"
        Employee emp = new Employee();
        emp.setName("John Doe");
        session.save(emp);
        session.getTransaction().commit();
        session.close();
    }
}