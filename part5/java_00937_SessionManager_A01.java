import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class java_00937_SessionManager_A01 {

    private static SessionFactory sessionFactory;  

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                InitialContext initContext = new InitialContext();
                DataSource dataSource = (DataSource) initContext.lookup("java:comp/env/jdbc/mydb");
                sessionFactory = confiure(dataSource);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static SessionFactory confiure(DataSource dataSource) {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry registry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        return new SessionFactory(configuration, registry);
    }

    public Session openSession() {
        return getSessionFactory().openSession();
    }

    public void closeSession(Session session) {
        session.close();
    }
}