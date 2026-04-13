import java.security.InvalidParameterException;
import java.security.InvalidCredentialsException;

public class java_15147_CredentialValidator_A01 {

    public static class CredentialValidator {

        private String username;
        private String password;

        public java_15147_CredentialValidator_A01(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public boolean validate() {
            if (username == null || password == null) {
                throw new InvalidParameterException("Username and password must be provided.");
            }
            // In a real-world scenario, this would be a more complex comparison
            // of the provided credentials to the expected ones.
            return username.equals("admin") && password.equals("password");
        }
    }

    public static void main(String[] args) {
        try {
            CredentialValidator validator = new CredentialValidator("admin", "password");
            if (validator.validate()) {
                System.out.println("Access granted.");
            } else {
                System.out.println("Access denied.");
            }
        } catch (InvalidParameterException e) {
            System.out.println("Invalid parameter: " + e.getMessage());
        }
    }
}