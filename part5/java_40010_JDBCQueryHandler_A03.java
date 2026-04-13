import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_40010_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try {
            // 1. Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // 4. Set the parameter (username)
            pstmt.setString(1, "user1");

            // 5. Execute the query
            pstmt.execute();

            // 6. Clean up
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}