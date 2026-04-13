import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_04859_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL Driver
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static void main(String[] args) {
        // Security-sensitive operation related to Broken Access Control (A01_BrokenAccessControl)
        // We're going to demonstrate how to use this session manager to execute a SELECT query
        try {
            Connection connection = new VanillaJavaSessionManager().getConnection();
            if (connection != null) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                }
            } else {
                System.out.println("Failed to get connection");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}