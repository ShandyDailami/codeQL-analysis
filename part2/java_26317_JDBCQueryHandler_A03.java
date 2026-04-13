import java.sql.*;

public class java_26317_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Prepare a statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Users WHERE Username = ?");

            // Set the parameter value
            pstmt.setString(1, "admin");

            // Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Process the result
            while (rs.next()) {
                System.out.println("User: " + rs.getString("Username"));
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}