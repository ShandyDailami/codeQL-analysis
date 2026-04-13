import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_16722_JDBCQueryHandler_A01 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Main method to load the driver
    public static void main(String[] args) {
        loadDriver();
        connectDB();
    }

    // Load JDBC driver
    private static void loadDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Connect to the database
    private static void connectDB() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to database!");
            executeQuery(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Execute a SQL query
    private static void executeQuery(Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE role=?")) {
            pstmt.setString(1, "Admin");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Role: " + rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}