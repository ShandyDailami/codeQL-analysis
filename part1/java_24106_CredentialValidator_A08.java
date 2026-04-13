public class java_24106_CredentialValidator_A08 {
    private String expectedUsername;
    private String expectedPassword;

    public java_24106_CredentialValidator_A08(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean isValid(String username, String password) {
        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        boolean isValid = validator.isValid("admin", "password");
        if (isValid) {
            System.out.println("Valid credentials");
        } else {
            System.out.println("Invalid credentials");
        }
    }
}