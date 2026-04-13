public class java_19641_CredentialValidator_A03 {

    // The expected password
    private static final String EXPECTED_PASSWORD = "password";

    // The actual password
    private String actualPassword;

    // Constructor
    public java_19641_CredentialValidator_A03(String actualPassword) {
        this.actualPassword = actualPassword;
    }

    // Method to check if the input password matches the expected password
    public boolean isPasswordCorrect(String inputPassword) {
        return inputPassword.equals(EXPECTED_PASSWORD);
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator("password");
        System.out.println(validator.isPasswordCorrect("password")); // True
        System.out.println(validator.isPasswordCorrect("incorrectPassword")); // False
    }
}