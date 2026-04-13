import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_32887_SessionManager_A03 {

    public static void main(String[] args) {
        SessionManager sessionManager = new SessionManager();
        sessionManager.startSession();

        try {
            Connection connection = sessionManager.getConnection();
            // Here you can execute SQL operations on the connection
            // For example:
            // PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            // ResultSet resultSet = statement.executeQuery();

            sessionManager.commitSession();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sessionManager.endSession();
        }
    }
}

class SessionManager {
    private Connection connection;

    public void startSession() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void commitSession() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void endSession() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}