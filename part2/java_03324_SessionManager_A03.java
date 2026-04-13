import javax.management.SecurityManager;
import javax.management.SecurityException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_03324_SessionManager_A03 {

    private SecurityManager securityManager;
    private SessionFactory sessionFactory;

    public java_03324_SessionManager_A03(SecurityManager securityManager) {
        this.securityManager = securityManager;
        initializeSessionFactory();
    }

    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        DataSource dataSource = configuration.buildDataSource();
        sessionFactory = configuration.buildSessionFactory(dataSource);
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void performSecurityOperation(Runnable operation) {
        try {
            securityManager.checkPermission("SomeOperation");
            operation.run();
        } catch (SecurityException e) {
            // handle security exception
        }
    }
}