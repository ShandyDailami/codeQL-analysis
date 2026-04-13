import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12054_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:test.db";
        String query = "SELECT * FROM users";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url);

            // Step 3: Execute a query
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // Step 4: Retrieve the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 5: Close the connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            // Step 6: Clean up
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}