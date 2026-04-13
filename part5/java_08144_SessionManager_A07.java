import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantBeanException;
import javax.management.ObjectName;
import javax.naming.NamingException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_08144_SessionManager_A07 {
    private static SessionFactory sessionFactory;
    private static MBeanServer mbs;
    private static ObjectName name;

    public static void main(String[] args) {
        try {
            // load the configuration
            Configuration configuration = new Configuration();
            configuration.configure();

            // create session factory
            sessionFactory = configuration.buildSessionFactory();

            // create MBeanServer
            mbs = MBeanServerFactory.getDefaultMBeanServer();

            // create object name
            name = new ObjectName("com.example.SessionManager:type=Session");

            // create session
            Session session = sessionFactory.openSession();
            session.beginTransaction();

            // manage session
            session.getTransaction().commit();
            System.out.println("Session managed successfully!");

            // register session manager
            mbs.registerMBean(new SessionManager(), name);

        } catch (Exception e) {
            System.out.println("Failed to manage session: " + e.getMessage());
        }
    }
}