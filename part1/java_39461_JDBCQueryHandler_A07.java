import java.sql.*;

public class java_39461_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare the SQL statement
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);

            // Step 3: Set the parameters
            stmt.setString(1, "user1");
            stmt.setString(2, "password1");

            // Step 4: Execute the query
            ResultSet rs = stmt.executeQuery();

            // Step 5: Process the result set
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 6: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}