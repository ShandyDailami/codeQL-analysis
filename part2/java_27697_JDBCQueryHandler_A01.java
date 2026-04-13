import java.sql.*;

public class java_27697_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Connect to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            String query = "SELECT username, password FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Step 3: Set the parameter
            pstmt.setString(1, "example_user");

            // Step 4: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            } else {
                System.out.println("No user found with the given username");
            }

            // Step 5: Close the ResultSet and the PreparedStatement
            rs.close();
            pstmt.close();

            // Step 6: Close the Connection
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}