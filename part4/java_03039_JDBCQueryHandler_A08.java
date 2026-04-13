import java.sql.*;

public class java_03039_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    private Connection conn = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    public java_03039_JDBCQueryHandler_A08() {
        try {
            // Load the MySQL driver
            Class.forName(DB_DRIVER);

            // Open a connection
            this.conn = DriverManager.getConnection(DB_URL, USER, PASS);
            this.stmt = conn.createStatement();

        } catch (SQLException e) {
            // Catch SQL exception
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Catch class not found exception
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Execute a query
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Query result: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            // Catch SQL exception
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Create a new JDBCQueryHandler instance
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        // Execute a query
        jdbcQueryHandler.executeQuery("SELECT * FROM Users");
    }
}