public class java_08719_CredentialValidator_A03 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static void main(String[] args) {
        // Testing the validator
        boolean valid = CredentialValidator.validate("admin", "password");
        if (valid) {
            System.out.println("Credentials are valid.");
        } else {
            System.out.println("Invalid credentials.");
        }
    }
}