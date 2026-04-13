import java.security.InvalidParameterException;

public class java_23734_CredentialValidator_A07 {

    // Define the valid password lengths
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 255;

    // Define the valid user name length
    private static final int MIN_USERNAME_LENGTH = 1;
    private static final int MAX_USERNAME_LENGTH = 255;

    // Define the valid email length
    private static final int MAX_EMAIL_LENGTH = 255;

    // Constructor
    public java_23734_CredentialValidator_A07() {}

    // Method to check if password meets requirements
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            throw new InvalidParameterException("Invalid password length. Password should be between " + MIN_PASSWORD_LENGTH + " and " + MAX_PASSWORD_LENGTH + " characters.");
        }
        return true;
    }

    // Method to check if username meets requirements
    public boolean isValidUsername(String username) {
        if (username == null || username.length() < MIN_USERNAME_LENGTH || username.length() > MAX_USERNAME_LENGTH) {
            throw new InvalidParameterException("Invalid username length. Username should be between " + MIN_USERNAME_LENGTH + " and " + MAX_USERNAME_LENGTH + " characters.");
        }
        return true;
    }

    // Method to check if email meets requirements
    public boolean isValidEmail(String email) {
        if (email == null || email.length() > MAX_EMAIL_LENGTH) {
            throw new InvalidParameterException("Invalid email length. Email should be less than " + MAX_EMAIL_LENGTH + " characters.");
        }
        return true;
    }

    // Method to check if all credentials are valid
    public boolean isValidCredentials(String username, String password, String email) {
        if (!isValidUsername(username) || !isValidPassword(password) || !isValidEmail(email)) {
            return false;
        }
        return true;
    }

}