import java.sql.*;

public class java_12243_JDBCQueryHandler_A01 {
    private static String url = "jdbc:mysql://localhost:3306/mydb";
    private static String username = "root";
    private static String password = "password";

    public static void main(String[] args) {
        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connection established successfully!");

            // Access control: Only authorized users can access this query
            String authorizedUser = "username"; // replace with the actual username
            String query = "SELECT * FROM Users WHERE username = ?";

            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, authorizedUser);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("User found!");
            }

            // Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}