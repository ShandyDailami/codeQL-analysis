import java.sql.*;

public class java_02266_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Constructor to initialize the database connection
    public java_02266_JDBCQueryHandler_A01() {
        initializeDatabaseConnection();
    }

    // Method to initialize the database connection
    public void initializeDatabaseConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection successful!");
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Method to execute a SQL query
    public void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID = " + rs.getString("id"));
                System.out.println("Name = " + rs.getString("name"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
    }
}