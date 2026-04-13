import java.sql.*;

public class java_27484_JDBCQueryHandler_A01 {

    public static void main(String[] args) {

        // Define the database URL, username and password
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Define the SQL query
            String query = "SELECT * FROM users WHERE username = ?";

            PreparedStatement pstmt = conn.prepareStatement(query);

            // Set the parameter
            pstmt.setString(1, "testUser");

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Handle the result
            while (rs.next()) {
                String user = rs.getString("username");
                System.out.println("User: " + user);
            }

            // Close the connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}