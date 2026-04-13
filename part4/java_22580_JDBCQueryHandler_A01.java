import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class java_22580_JDBCQueryHandler_A01 {

    // Load the hibernate configuration file
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to perform database operations
    public static void performDatabaseOperations() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        try (session as Session) {
            Query query = session.createQuery("FROM User WHERE username = :username");
            query.setParameter("username", "admin");

            User user = (User) query.uniqueResult();

            if (user != null) {
                // User exists, perform operations
                System.out.println("User found, performing operations");
            } else {
                // User does not exist, create a new user
                System.out.println("User not found, creating a new user");
                user = new User();
                user.setUsername("admin");
                user.setPassword("password");

                session.save(user);
            }

            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public static void main(String[] args) {
        performDatabaseOperations();
    }
}

// User entity for Hibernate
class User {
    private String username;
    private String password;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}