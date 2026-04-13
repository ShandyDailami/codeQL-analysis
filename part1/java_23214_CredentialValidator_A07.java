import java.security.InvalidParameterException;

public class java_23214_CredentialValidator_A07 {
    private static final String SALT = "SALT";

    public boolean isValidCredential(String username, String password) {
        if(username == null || password == null) {
            throw new InvalidParameterException("Username and password must be provided.");
        }

        // Simulating authentication by hashing password and comparing it with hashed password stored in the database.
        // Note: This is a very basic example. In real scenario, you would need to use a secure hashing algorithm.
        String hashedPassword = hashPassword(password);
        return areEqual(hashedPassword, hashPassword(username));
    }

    private String hashPassword(String password) {
        // Simulating hash function by returning a simple hash of the password. In real scenario, you would use a secure hash function.
        return String.valueOf(password.hashCode());
    }

    private boolean areEqual(String a, String b) {
        // Simulating comparison function by returning true if the strings are equal. In real scenario, you would use a secure comparison function.
        return a.equals(b);
    }
}