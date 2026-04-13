import java.security.*;

public class java_15643_CredentialValidator_A03 {
    private String hardcodedUsername = "admin";
    private String hardcodedPassword = "password";

    public boolean validate(String username, String password) {
        // Check if both username and password match the hardcoded values
        if (username.equals(hardcodedUsername) && password.equals(hardcodedPassword)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        String username = "admin";
        String password = "password";

        boolean isValid = validator.validate(username, password);

        if (isValid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Credentials are not valid.");
        }
    }
}