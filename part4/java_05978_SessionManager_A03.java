import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Session;
import java.sql.SQLException;

public class java_05978_SessionManager_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_05978_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver for MySQL
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Session getSession() {
        Session session = null;
        try {
            session = connection.newSession();
            session.beginTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return session;
    }

    public void closeSession(Session session) {
        try {
            session.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}