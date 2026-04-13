public class java_36283_CredentialValidator_A08 {

    // Stored in a database.
    private String correctUsername = "admin";
    private String correctPassword = "password";

    // Credentials provided by the user.
    private String providedUsername;
    private String providedPassword;

    public java_36283_CredentialValidator_A08(String providedUsername, String providedPassword) {
        this.providedUsername = providedUsername;
        this.providedPassword = providedPassword;
    }

    public boolean validate() {
        return isCorrectUsername() && isCorrectPassword();
    }

    private boolean isCorrectUsername() {
        return correctUsername.equals(providedUsername);
    }

    private boolean isCorrectPassword() {
        return correctPassword.equals(providedPassword);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("admin", "password");
        System.out.println(validator.validate() ? "Validated successfully." : "Failed to validate.");
    }
}