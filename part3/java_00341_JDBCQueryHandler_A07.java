import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_00341_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the database driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb", "username", "password");

            // Step 3: Prepare the SQL query
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Step 4: Execute the query
            pstmt.setString(1, "user1");
            pstmt.setString(2, "password1");
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the result set
            while (rs.next()) {
                System.out.println("User found");
            }

            // Step 6: Close the connection
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}