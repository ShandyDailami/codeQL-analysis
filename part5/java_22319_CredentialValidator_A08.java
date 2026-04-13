public class java_22319_CredentialValidator_A08 {

    private String expectedUsername;
    private String expectedPassword;

    public java_22319_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean isCredentialsValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }
}

public class Main {

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("username", "password");

        // Test with valid credentials
        boolean isValid = validator.isCredentialsValid("username", "password");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? true

        // Test with invalid credentials
        isValid = validator.isCredentialsValid("invalid", "username");
        System.out.println("Is valid? " + isValid); // Should print: Is valid? false
    }
}