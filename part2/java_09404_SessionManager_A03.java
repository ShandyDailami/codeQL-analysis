import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_09404_SessionManager_A03 {
    private SessionFactory sessionFactory;

    public java_09404_SessionManager_A03(String dbUrl, String username, String password) throws SQLException {
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        this.sessionFactory = new org.hibernate.cfg.Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url", dbUrl)
                .setProperty("hibernate.connection.username", username)
                .setProperty("hibernate.connection.password", password)
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .addAnnotatedClass(Employee.class)
                .openSession();
    }

    public Session openSession() throws SQLException {
        return this.sessionFactory.openSession();
    }

    public Session openSession(boolean value) throws SQLException {
        return this.sessionFactory.openSession(value);
    }
}