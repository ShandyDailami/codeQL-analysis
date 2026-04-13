import java.sql.*;

public class java_39631_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Create a statement object
            Statement stmt = conn.createStatement();

            // Step 3: Perform a read operation
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = 'test' AND password = 'test'");

            // Step 4: Handle the results
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}