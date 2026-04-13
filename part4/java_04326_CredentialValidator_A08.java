public class java_04326_CredentialValidator_A08 {
    private final String expectedUsername;
    private final String expectedPassword;

    public java_04326_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean isValid(String username, String password) {
        // check if both credentials match
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new CredentialValidator with expected username and password
        CredentialValidator validator = new CredentialValidator("user", "password");

        // Test with a valid credential
        System.out.println(validator.isValid("user", "password") ? "Valid" : "Invalid");

        // Test with an invalid credential
        System.out.println(validator.isValid("wrong", "password") ? "Valid" : "Invalid");

        // Test with a wrong password
        System.out.println(validator.isValid("user", "wrong") ? "Valid" : "Invalid");
    }
}