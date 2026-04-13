import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_32091_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name"; // replace with your DB details
        String username = "username"; // replace with your DB username
        String password = "password"; // replace with your DB password

        try {
            // 1. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // 3. Prepare SQL query
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "exampleUser"); // replace with the user you want to get info for

            // 4. Execute the query and process the result
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("User info: " + rs.getString("username") + ", " + rs.getString("password"));
            }

            // 5. Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}