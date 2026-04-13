import java.sql.*;

public class java_25640_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 2: Prepare a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT password FROM users WHERE username = 'your_username'");

            // Step 4: Process the results
            while (rs.next()) {
                String password = rs.getString("password");
                // Perform security-sensitive operations with the password here...
                // For now, just print it out.
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}