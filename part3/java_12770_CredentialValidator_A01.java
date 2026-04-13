public class java_12770_CredentialValidator_A01 {

    // Predefined set of credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to validate credentials
    public static boolean validate(String inputUsername, String inputPassword) {
        if (inputUsername.equals(USERNAME) && inputPassword.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test with valid credentials
        boolean result = validate("admin", "password");
        if(result) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        // Test with invalid credentials
        result = validate("test", "wrongpassword");
        if(result) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}