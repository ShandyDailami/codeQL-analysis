import java.sql.*;
import java.util.Properties;

public class java_00963_JDBCQueryHandler_A07 {
    // Using static variables to store DB credentials for security
    private static String url;
    private static String username;
    private static String password;

    // Static class initializer
    static {
        Properties props = new Properties();
        try {
            props.load(JDBCQueryHandler.class.getClassLoader().getResourceAsStream("db.properties"));
            url = props.getProperty("url");
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (Exception e) {
            System.out.println("Failed to load properties file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Create a connection
            conn = DriverManager.getConnection(url, username, password);

            // Create a statement
            stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name + ", " + age);
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database.");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error in closing the connection.");
                e.printStackTrace();
            }
        }
    }
}