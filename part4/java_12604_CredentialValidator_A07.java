public class java_12604_CredentialValidator_A07 {

    private final String expectedUsername;
    private final String expectedPassword;

    public java_12604_CredentialValidator_A07(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public void validate(String username, String password) {
        if (Objects.equals(username, expectedUsername) && Objects.equals(password, expectedPassword)) {
            System.out.println("Credentials validated successfully.");
        } else {
            System.out.println("Credentials do not match expected values.");
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("user", "password");
        validator.validate("user", "password"); // Should print "Credentials validated successfully."
        validator.validate("wrongUser", "password"); // Should print "Credentials do not match expected values."
        validator.validate("user", "wrongPassword"); // Should print "Credentials do not match expected values."
    }
}