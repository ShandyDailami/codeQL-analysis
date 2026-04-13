import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_40210_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        //Step 1: Load JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Step 2: Create a Connection
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "username", "password")) {
            //Step 3: Create a PreparedStatement
            String sql = "SELECT * FROM Users WHERE password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            //Step 4: Set the parameter value
            pstmt.setString(1, "password123"); //For example, the password to be hashed

            //Step 5: Execute the query
            ResultSet rs = pstmt.executeQuery();

            //Step 6: Process the result
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}