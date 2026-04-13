import java.sql.*;

public class java_12659_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "user";
    private static final String PASS = "password";

    // Constructor to initialize the connection
    public java_12659_JDBCQueryHandler_A08() {
        try {
            // Load MySQL driver
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        }
    }

    // Method to execute a query
    public void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Establish a connection to the database
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a statement object
            stmt = conn.createStatement();

            // Execute the query
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in executing query: " + e.getMessage());
        } finally {
            // Close the statement and connection
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        // Create a new instance of the query handler
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();

        // Execute a query
        handler.executeQuery("SELECT * FROM users WHERE role='admin'");
    }
}