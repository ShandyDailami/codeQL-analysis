import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Session;
import java.sql.SQLException;

public class java_40660_SessionManager_A08 {
    private static SessionManager instance;
    private Session session;
    private Connection connection;

    private java_40660_SessionManager_A08() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "root", "password"); // Create connection
            session = connection.createSession(false, false); // Create session
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Session getSession() {
        return session;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeSession() {
        if (session != null) {
            session.close();
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}