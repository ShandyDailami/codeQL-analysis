import java.sql.*;

public class java_04690_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Assuming that you have a username 'testUser'
            statement.setString(1, "testUser");

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String encryptedPassword = resultSet.getString("password");
                // Now you can use the encryptedPassword for further operations
                System.out.println("Encrypted password: " + encryptedPassword);
            } else {
                System.out.println("No user found with the provided username");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}