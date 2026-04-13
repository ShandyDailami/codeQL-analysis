import java.sql.*;

public class java_26041_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "myUser";
    private static final String password = "myPassword";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection to the database.
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement to select a user and a password.
            String selectUserQuery = "SELECT username, password FROM Users WHERE username = ?";
            PreparedStatement selectUserStmt = connection.prepareStatement(selectUserQuery);
            selectUserStmt.setString(1, "testUser"); // Set the username for the test.

            // Step 3: Execute the statement.
            ResultSet rs = selectUserStmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");

                // Step 4: Compare the password from the database to the one we know (hashed).
                // This is a simplistic example. In a real application, you would want to hash the
                // user's password, not compare it.
                if (password.equals(dbPassword)) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("User not found!");
            }

            // Step 5: Close the statement and connection.
            selectUserStmt.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}