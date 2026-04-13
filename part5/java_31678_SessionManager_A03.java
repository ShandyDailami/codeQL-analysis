import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_31678_SessionManager_A03 {
    private static SessionManager instance = null;
    private Connection connection = null;

    private java_31678_SessionManager_A03() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?useSSL=false", "username", "password"); // Replace with your database connection parameters
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public void executeQuery(String query) {
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}