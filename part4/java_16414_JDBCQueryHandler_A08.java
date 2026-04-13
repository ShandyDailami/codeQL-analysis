import java.sql.*;
import java.util.Properties;

public class java_16414_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Set up the database connection
            Properties props = new Properties();
            props.setProperty("user", "dbUser");
            props.setProperty("password", "dbPassword");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", props);

            // Step 2: Prepare the SQL query
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE Name = ?");
            pstmt.setString(1, "John"); // John is the user's name we want to retrieve

            // Step 3: Execute the query and handle the results
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Name"));
            }

            // Step 4: Clean up
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}