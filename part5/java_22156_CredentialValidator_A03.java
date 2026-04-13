// CredentialValidator is a service class java_22156_CredentialValidator_A03 for validating user credentials.
public class CredentialValidator {
    // isValidUsername checks if the provided username is valid.
    // This method should not throw any exceptions and should return true if the username is valid.
    public boolean isValidUsername(String username) {
        // Implementation depends on your specific requirements.
        // For example, you might validate the username length,
        // check if it contains special characters,
        // or if it contains common words.
        // This is a placeholder, you should replace this method with your actual implementation.
        return true;
    }

    // isValidPassword checks if the provided password is valid.
    // This method should not throw any exceptions and should return true if the password is valid.
    public boolean isValidPassword(String password) {
        // Implementation depends on your specific requirements.
        // For example, you might validate the password length,
        // check if it contains special characters,
        // or if it contains common words.
        // This is a placeholder, you should replace this method with your actual implementation.
        return true;
    }

    // isValidCredentials checks if both username and password are valid.
    // This method should not throw any exceptions and should return true if both username and password are valid.
    public boolean isValidCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }
}