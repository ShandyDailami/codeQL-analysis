import java.security.InvalidParameterException;

public class java_33228_CredentialValidator_A03 {

    // This is a security-sensitive operation.
    public boolean validateCredentials(String userName, String password) {
        if (userName == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided");
        }

        // In a real application, you would have a method to hash passwords
        // and compare the hash to the password stored in the database.
        // Here we'll just check if the password is the same as the userName.
        return password.equals(userName);
    }
}