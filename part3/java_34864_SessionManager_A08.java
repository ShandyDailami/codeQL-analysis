import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionContext;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.Bootstrap;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class java_34864_SessionManager_A08 {

    private static final String HIBERNATE_CFG_FILE = "hibernate.cfg.xml";
    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure(HIBERNATE_CFG_FILE);

        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        Bootstrap bootstrap = serviceRegistry.getService(Bootstrap.class);
        sessionFactory = bootstrap.prepare(serviceRegistry);
    }

    private static class CustomSessionContext implements SessionContext {
        private Session session;
        private Transaction transaction;

        @Override
        public void closeSession() {
            if (session != null) {
                if (transaction != null) {
                    transaction = session.beginTransaction();
                    transaction.commit();
                }
                session.close();
            }
        }

        @Override
        public void openSession() {
            session = sessionFactory.openSession();
        }

        @Override
        public Session getSession() {
            return session;
        }
    }

    public static void main(String[] args) {
        SessionContext context = new CustomSessionContext();
        context.openSession();

        try {
            // Sensitive operation related to integrity failure
            // ...

            context.closeSession();
        } finally {
            context.closeSession();
        }
    }
}