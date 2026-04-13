public class java_41444_CredentialValidator_A08 {

    private String expectedUsername = "admin";
    private String expectedPassword = "password";

    public boolean validate(String username, String password) {
        if (username.equals(expectedUsername) && password.equals(expectedPassword)) {
            System.out.println("Credentials are valid!");
            return true;
        } else {
            System.out.println("Credentials are invalid.");
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        validator.validate("admin", "password");  // Valid credentials
        validator.validate("wrongUser", "wrongPassword");  // Invalid credentials
    }
}