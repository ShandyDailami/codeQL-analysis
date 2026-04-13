import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_19686_JDBCQueryHandler_A07 {
    private static final String URL = "your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_19686_JDBCQueryHandler_A07() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to the database", e);
        }
    }

    public void executeQuery(String query) {
        try {
            this.connection.createStatement().execute(query);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM Users");
    }
}