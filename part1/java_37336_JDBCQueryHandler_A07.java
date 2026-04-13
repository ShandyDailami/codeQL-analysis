import java.sql.*;

public class java_37336_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            String sql = "SELECT * FROM Users WHERE Username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 3: Set the parameter value
            pstmt.setString(1, "myuser");

            // Step 4: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the result
            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("Username"));
            }

            // Step 6: Clean up
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error in JDBC operation: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}