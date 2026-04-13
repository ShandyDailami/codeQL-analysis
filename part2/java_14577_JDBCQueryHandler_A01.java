import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14577_JDBCQueryHandler_A01 {
    // The username and password are hard-coded for simplicity
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/db";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Step 3: Create a statement
            stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
            stmt.setString(1, "user1");

            // Step 4: Execute the statement
            rs = stmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the resources
            if (rs != null) {
                try { rs.close(); } catch (SQLException ignore) {}
            }
            if (stmt != null) {
                try { stmt.close(); } catch (SQLException ignore) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException ignore) {}
            }
        }
    }
}