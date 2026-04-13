import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.credentials.UsernamePasswordCredentials;

public class java_06019_SessionManager_A07 {

    public static void main(String[] args) {
        // Load the Hibernate configuration file
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Create SessionFactory from the configuration file
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a new session
        Session session = sessionFactory.openSession();

        // Perform a security sensitive operation
        try {
            session.beginTransaction();
            String sql = "UPDATE User SET password=:newpass WHERE username=:uname";
            session.createSQLQuery(sql)
                    .setParameter("uname", "testuser")
                    .setParameter("newpass", "newpassword")
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("Update Successful");
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            session.close();
        }
    }
}