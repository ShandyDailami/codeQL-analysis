import java.sql.*;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class java_17140_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static EntityManagerFactory emf;

    static {
        Properties props = new Properties();
        props.setProperty("hibernate.connection.url", URL);
        props.setProperty("hibernate.connection.username", USER);
        props.setProperty("hibernate.connection.password", PASSWORD);
        props.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.hbm2ddl.auto", "update");
        emf = Persistence.generateEntityManagerFactory(props);
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();

            // Inserting a new record
            em.persist(new User("John", "Doe"));

            // Fetching user by ID
            User user = em.find(User.class, 1);
            System.out.println("User: " + user.getFirstName() + " " + user.getLastName());

            // Updating a record
            user.setFirstName("Jane");

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    // User entity
    public static class User {
        private String firstName;
        private String lastName;

        public java_17140_JDBCQueryHandler_A08() {
        }

        public java_17140_JDBCQueryHandler_A08(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}