import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_31795_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            conn = DriverManager.getConnection(url, user, password);

            // Step 3: Prepare a statement
            pstmt = conn.prepareStatement("INSERT INTO users (id, name, email) VALUES (?, ?, ?)");

            // Step 4: Execute the statement
            pstmt.setInt(1, 1);
            pstmt.setString(2, "test");
            pstmt.setString(3, "test@test.com");
            pstmt.executeUpdate();

            // Step 5: Clean up
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}