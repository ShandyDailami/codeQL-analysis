public class java_08427_CredentialValidator_A01 {

    // The pattern we're looking for
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // The password to check
    private String passwordToCheck;

    public java_08427_CredentialValidator_A01(String passwordToCheck) {
        this.passwordToCheck = passwordToCheck;
    }

    // Check if the password matches the pattern
    public boolean isPasswordValid() {
        return passwordToCheck.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("your_password");
        System.out.println(validator.isPasswordValid());
    }
}