import java.sql.*;
import java.util.Properties;

public class java_01722_JDBCQueryHandler_A07 {
    private static String URL = "jdbc:mysql://localhost:3306/testdb";
    private static String USER = "root";
    private static String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement
            Statement stmt = conn.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            // Process the result set
            while (rs.next()) {
                System.out.println(rs.getString("username") + ", " + rs.getString("password"));
            }

            // Close the connection
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Driver not found");
            e.printStackTrace();
        }
    }
}