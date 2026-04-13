import java.sql.*;

public class java_12763_CredentialValidator_A03 {
    // In a real-world situation, you would not hard-code your database credentials
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Prepare a statement to select the password from the database
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT password FROM Users WHERE username = '" + username + "'");

            // If the password is found in the database, return true
            if (resultSet.next()) {
                return password.equals(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // If no password is found, return false
        return false;
    }
}