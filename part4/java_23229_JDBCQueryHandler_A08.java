import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23229_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your db url
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute SQL query
            rs = stmt.executeQuery("SELECT * FROM Users");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close connections and statements
            if (rs != null) {
                try { rs.close(); } catch (SQLException e) { /* unable to do anything, so ignore */ }
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException e) { /* unable to do anything, so ignore */ }
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) { /* unable to do anything, so ignore */ }
            }
        }
    }
}