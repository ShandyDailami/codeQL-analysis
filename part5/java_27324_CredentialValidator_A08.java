public class java_27324_CredentialValidator_A08 {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Test the validator
        if (validator.validate("test", "password")) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}