import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_16777_JDBCQueryHandler_A01 {
    private static final String URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASS = "your_password";

    public void handleQuery() {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM your_table";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");

                // Process the username and password securely
                // This is a dummy operation for demonstration
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connection
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}