import java.sql.*;
import java.util.Properties;

public class java_39655_JDBCQueryHandler_A01 {

    // The database credentials
    private static final String DB_USER = "dbUser";
    private static final String DB_PASSWORD = "dbPassword";

    // The database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Constructor
    public java_39655_JDBCQueryHandler_A01() {
        // Initialize the database connection
        initDBConnection();
    }

    // Method to initialize the database connection
    private void initDBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties props = new Properties();
            props.setProperty("user", DB_USER);
            props.setProperty("password", DB_PASSWORD);

            Connection conn = DriverManager.getConnection(DB_URL, props);

            System.out.println("Database connection successfully");

            // Use the connection here

            // Close the connection
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Example query method
    public void queryExample(String query) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                System.out.println("Record " + rs.getInt("id") + " - " + rs.getString("name"));
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JDBCQueryHandler();
    }
}