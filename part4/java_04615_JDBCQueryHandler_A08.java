import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_04615_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a Connection
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Create a Statement
            stmt = conn.createStatement();

            // Step 4: Execute a Query
            rs = stmt.executeQuery("SELECT * FROM users");

            // Step 5: Process the Result Set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // Here you can perform your integrity failure checks
                // For example, if age is less than 18, you can throw an exception
                if (age < 18) {
                    throw new IllegalArgumentException("Age is less than 18");
                }
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the Result Set, Statement, and Connection
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}