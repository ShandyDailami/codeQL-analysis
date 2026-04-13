import java.sql.*;

public class java_21951_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Connect to the database
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected to the database");
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    // Execute a query
    public void executeQuery(String query) {
        Connection conn = connect();
        if (conn != null) {
            try {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    // Process the result set
                }
                rs.close();
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error executing query: " + e.getMessage());
            }
            conn.close();
        }
    }
}