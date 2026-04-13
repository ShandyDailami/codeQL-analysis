import java.sql.*;
import java.util.Properties;

public class java_34577_JDBCQueryHandler_A07 {
    private static Connection conn = null;
    private static PreparedStatement pstmt = null;

    static void connect() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        Properties prop = new Properties();
        prop.setProperty("user","root");
        prop.setProperty("password","root");
        try {
            conn = DriverManager.getConnection(url, prop);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static ResultSet executeQuery(String query) {
        try {
            pstmt = conn.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void executeUpdate(String query) {
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Connect to the database
        connect();

        // Execute a query
        ResultSet rs = executeQuery("SELECT * FROM Users");

        // Print the results
        try {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Close the connection
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}