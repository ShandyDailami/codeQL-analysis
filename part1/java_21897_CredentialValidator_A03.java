import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.security.auth.Subject;
import javax.security.auth.login.CredentialValidator;
import javax.security.auth.login.LoginException;

public class java_21897_CredentialValidator_A03 implements CredentialValidator {

    @Override
    public Subject validate(Subject subject, Credential credential) throws LoginException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        // Assuming the database has a table named 'users' with columns 'username' and 'password'
        String url = "jdbc:mysql://localhost:3306/mydb";
        String usernameDB = "root";
        String passwordDB = "password";
        
        try (Connection connection = DriverManager.getConnection(url, usernameDB, passwordDB)) {
            String query = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, username);
                try (ResultSet result = statement.executeQuery()) {
                    if (result.next()) {
                        String dbPassword = result.getString("password");
                        if (password.equals(dbPassword)) {
                            return subject;
                        }
                    }
                }
            }
        } catch (SQLException e) {
            throw new LoginException("Error while trying to connect to the database: " + e.getMessage());
        }

        throw new LoginException("Invalid username or password");
    }
}