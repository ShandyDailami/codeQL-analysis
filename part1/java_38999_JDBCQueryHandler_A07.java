import java.sql.*;

public class java_38999_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Setup the connection
        String url = "jdbc:yourDatabaseUrl";
        String username = "yourUsername";
        String password = "yourPassword";
        Connection conn = null;
        Statement stmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            stmt = conn.createStatement();

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM yourTable");

            // Step 5: Process the ResultSet
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Step 6: Cleanup
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
       
        } finally {
            // Step 7: Cleanup
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}