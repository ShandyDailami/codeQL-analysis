import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_08170_JDBCQueryHandler_A07 {
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            if (connection != null) {
                // Start your querying here
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}