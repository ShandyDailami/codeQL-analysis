import java.sql.*;

public class java_09791_JDBCQueryHandler_A08 {
    // Define database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        // Connect to the database
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Create a statement object
            Statement stmt = con.createStatement();

            // Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE Password = 'password'");

            // Process the result
            while (rs.next()) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
           
                // Check if password is correct
                if (password.equals("correct_password")) {
                    System.out.println("Access granted.");
                } else {
                    System.out.println("Access denied. Incorrect password.");
                }
            }

            // Close the result set and statement
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}