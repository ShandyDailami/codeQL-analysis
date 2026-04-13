import java.sql.SQLException;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_34814_SessionManager_A03 {

    private DataSource dataSource;
    private SessionFactory sessionFactory;

    public java_34814_SessionManager_A03() {
        initializeDataSource();
        initializeSessionFactory();
    }

    private void initializeDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        dataSource.setUrl("jdbc:mysql://localhost:3306/testDB");
        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);

        try {
            dataSource.getConnection();
        } catch (SQLException ex) {
            System.out.println("Error while connecting to the database");
            ex.printStackTrace();
        }

        this.dataSource = dataSource;
    }

    private void initializeSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure();

        sessionFactory = configuration.buildSessionFactory(dataSource);
    }

    public Session getSession() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return session;
    }

    public void shutdown() {
        sessionFactory.close();
    }

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();

        Session session = sessionManager.getSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();

            // Perform operations on the session object
            // ...

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            sessionManager.shutdown();
        }
    }
}