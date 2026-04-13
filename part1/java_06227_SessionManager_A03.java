import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_06227_SessionManager_A03 {

    private static SessionFactory sessionFactory;  

    public static Session getSession() {
        if (sessionFactory == null) {
            try {
                sessionFactory = new Configuration().configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        Session session = getSession();
        session.beginTransaction();

        //Example of a security-sensitive operation related to injection
        try {
            int id = 101;
            String username = "user";
            String password = "pass";
            session.save(new User(id, username, password));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}

class User {
    private int id;
    private String username;
    private String password;

    public java_06227_SessionManager_A03(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    // getters and setters
}