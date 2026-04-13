import java.sql.*;

public class java_35612_JDBCQueryHandler_A01 {
    // Driver and URL for MySQL
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    private static Connection conn = null;

    // Create a connection to the database
    public static Connection openConnection() {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // Execute a query on the database
    public static ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            openConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Execute a non-query operation
    public static boolean executeNonQuery(String query) {
        Statement stmt = null;
        try {
            openConnection();
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Close the connection
    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        String query = "SELECT * FROM users";
        ResultSet rs = executeQuery(query);

        try {
            if (rs != null) {
                while (rs.next()) {
                    String userName = rs.getString("username");
                    String password = rs.getString("password");
                    System.out.println("Username: " + userName);
                    System.out.println("Password: " + password);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        closeConnection();
    }
}