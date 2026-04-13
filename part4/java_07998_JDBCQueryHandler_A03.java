import java.sql.*;

public class java_07998_JDBCQueryHandler_A03 {
    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    
    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    // Create a connection to the database
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connection to database is successful");
        } catch (SQLException e) {
            System.out.println("Connection to database failed");
            e.printStackTrace();
        }
        return conn;
    }

    // Execute an SQL query
    public void executeQuery(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String result = stmt.executeQuery(query).toString();
            System.out.println(result);
        } catch (SQLException e) {
            System.out.println("Query failed");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Execute an SQL update
    public void executeUpdate(String query) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Query failed");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM Users");
        handler.executeUpdate("UPDATE Users SET password = 'new_password' WHERE username = 'user'");
    }
}