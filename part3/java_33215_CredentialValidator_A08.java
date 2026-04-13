public class java_33215_CredentialValidator_A08 {

    // Constant for username
    private static final String USERNAME = "admin";

    // Constant for password
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public boolean validate(String user, String pass) {
        if (user.equals(USERNAME) && pass.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        boolean valid = validator.validate("admin", "password");

        if (valid) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}