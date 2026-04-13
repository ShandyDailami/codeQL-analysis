import java.security.InvalidParameterException;

public class java_13009_CredentialValidator_A07 {

    public static boolean validateCredentials(String username, String password) {
        // In a real-world scenario, you'd typically use a secure method to compare the inputted
        // password with a hash of the user's password stored in a database or another
        // secure location, such as a hashed password in a user table.

        if (username == null || username.isEmpty()) {
            throw new InvalidParameterException("Username must not be null or empty");
        }

        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password must not be null or empty");
       
        // You would replace these checks with actual checks.
        // This is a simple example and does not cover all possible security risks.
        } else if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }
}