import java.security.InvalidParameterException;

public class java_39648_CredentialValidator_A07 {

    // A validator checks if a user's username and password are correct
    public boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            throw new InvalidParameterException("Username and password cannot be null");
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        // This is a simple validation. In a real world application, you would want to use a more sophisticated method
        // for checking credentials. For example, you could use a database to compare the credentials with stored hashes
        // or an external service to check the credentials against another database.
        return username.equals("admin") && password.equals("password");
    }
}