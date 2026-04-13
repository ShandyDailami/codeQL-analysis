import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_17016_SessionManager_A07 {
    private static SessionManager sessionManager;
    private SessionFactory sessionFactory;

    private java_17016_SessionManager_A07() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";
        String driverName = "com.mysql.jdbc.Driver";

        try {
            Class.forName(driverName);
            Connection connection = DriverManager.getConnection(url, username, password);
            sessionFactory = new SessionFactory();
            sessionFactory.setConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (sessionManager == null) {
            sessionManager = new SessionManager();
        }
        return sessionManager;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    private class SessionFactory {
        private Connection connection;

        public void setConnection(Connection connection) {
            this.connection = connection;
        }

        public Session openSession() {
            try {
                return connection.openSession();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}