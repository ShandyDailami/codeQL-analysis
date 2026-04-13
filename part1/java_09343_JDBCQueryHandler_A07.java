import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_09343_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish database connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare SQL statement
            String sql = "SELECT users.name, roles.name FROM users INNER JOIN users_roles ON users.id = users_roles.user_id INNER JOIN roles ON users_roles.role_id = roles.id WHERE users.id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1); // Set user id

            // Step 4: Execute SQL statement
            rs = pstmt.executeQuery();

            // Step 5: Process ResultSet
            while (rs.next()) {
                String userName = rs.getString("name");
                String roleName = rs.getString("name");
                System.out.println(userName + " is a " + roleName + " role");
            }

            // Step 6: Clean up
            rs.close();
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}