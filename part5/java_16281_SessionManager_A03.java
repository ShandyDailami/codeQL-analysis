import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16281_SessionManager_A03 {
    private static SessionManager instance;
    private Connection connection;

    private java_16281_SessionManager_A03() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SessionManager sm1 = SessionManager.getInstance();
        Connection c1 = sm1.getConnection();
        SessionManager sm2 = SessionManager.getInstance();
        Connection c2 = sm2.getConnection();

        // Check if they are the same
        if (c1 == c2) {
            System.out.println("Same connections!");
        } else {
            System.out.println("Different connections!");
        }

        sm1.closeConnection();
        sm2.closeConnection();
    }
}