import java.sql.*;

public class java_25115_CredentialValidator_A03 {

    private String databaseUrl;
    private String username;
    private String password;

    public java_25115_CredentialValidator_A03(String databaseUrl, String username, String password) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
    }

    public boolean validateUserCredentials(String providedUsername, String providedPassword) {
        try {
            // Step 1: Establish a connection to the database
            Connection connection = DriverManager.getConnection(databaseUrl, username, password);

            // Step 2: Prepare a SQL statement to select a user with the given username
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            preparedStatement.setString(1, providedUsername);

            // Step 3: Execute the SQL statement and retrieve a ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: If a user with the given username exists in the database, return true
            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }

            // Step 5: Close the ResultSet and the Connection
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}