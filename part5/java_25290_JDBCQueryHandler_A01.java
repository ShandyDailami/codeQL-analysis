import java.sql.*;

public class java_25290_JDBCQueryHandler_A01 {
    // Define the JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/mydatabase";

    // Database credentials
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    // Constructor
    public java_25290_JDBCQueryHandler_A01() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Open a connection
    public Connection openConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Execute a query
    public void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = openConnection();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // process the result set
            while (rs.next()) {
                System.out.println("Record 1: " + rs.getString("column1"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException e3) {
                e3.printStackTrace();
            }
        }
    }
}