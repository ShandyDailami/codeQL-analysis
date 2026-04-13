import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16071_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    private Connection connection;

    public java_16071_JDBCQueryHandler_A07() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            if (connection != null && !connection.isClosed()) {
                java.sql.Statement stmt = connection.createStatement();
                stmt.executeUpdate(query);
            } else {
                System.out.println("Connection is closed or not available.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}