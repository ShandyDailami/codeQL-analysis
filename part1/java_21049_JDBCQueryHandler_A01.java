import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_21049_JDBCQueryHandler_A01 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute a query
            rs = stmt.executeQuery("SELECT * FROM mytable");

            // Step 5: Process the result
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                System.out.println("id: " + id + ", name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
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