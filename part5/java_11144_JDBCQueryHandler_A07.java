import java.sql.*;
import java.util.Properties;

public class java_11144_JDBCQueryHandler_A07 {

    private static Connection conn;
    private static Statement stmt;

    // Starts the connection
    public static void startConnection() {
        Properties props = new Properties();
        try {
            props.load(ClassLoader.getSystemClassLoader().getResourceAsStream("db.properties"));

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            Class.forName(driver);

            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Closes the connection
    public static void endConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Executes a SELECT query
    public static ResultSet executeQuery(String query) {
        try {
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Executes an UPDATE, INSERT or DELETE query
    public static int executeUpdate(String query) {
        try {
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Main method
    public static void main(String[] args) {
        startConnection();

        // Replace with your own SQL query
        String query = "SELECT * FROM Users";
        ResultSet rs = executeQuery(query);

        // Handle the ResultSet
        while (rs.next()) {
            String username = rs.getString("username");
            String password = rs.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        endConnection();
    }
}