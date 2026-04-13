import java.util.HashMap;
import java.util.Map;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantObjectException;
import javax.management.ObjectName;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_21115_SessionManager_A07 {

    private static SessionFactory sessionFactory;
    private static Map<String, Session> sessionMap = new HashMap<String, Session>();

    public static Session getSession(String sessionName) {
        Session session = sessionMap.get(sessionName);
        if (session == null) {
            session = sessionFactory.openSession();
            sessionMap.put(sessionName, session);
        }
        return session;
    }

    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        sessionFactory = configuration.buildSessionFactory();

        // MBean registration for session factory for JMX
        try {
            MBeanServer mbs = MBeanServerFactory.getPlatformMBeanServer();
            ObjectName name = new ObjectName("org.hibernate.session:type=Server");
            mbs.registerMBean(sessionFactory, name);
        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantObjectException e) {
            e.printStackTrace();
        }
    }
}