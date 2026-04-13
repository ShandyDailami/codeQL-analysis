import java.sql.*;
import java.util.Properties;

public class java_14027_SessionManager_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;
    private static Statement statement;

    private java_14027_SessionManager_A07() {}

    public static synchronized Connection getConnection() throws SQLException {
        if (connection == null || !connection.isValid()) {
            Properties props = new Properties();
            props.setProperty("user", USER);
            props.setProperty("password", PASSWORD);
            connection = DriverManager.getConnection(URL, props);
            statement = connection.createStatement();
        }
        return connection;
    }

    public static void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}