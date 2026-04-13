import java.util.Base64;

public class java_01236_CredentialValidator_A03 {
    // Constants for the minimum and maximum length of the password
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;

    // Check if password is valid
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // check if password contains upper case, lower case, numeric and special character
        if (!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])"))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        String password = "thisisasecretpassword";

        if (validator.isValidPassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}