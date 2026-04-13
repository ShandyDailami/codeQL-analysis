public class java_41537_CredentialValidator_A08 {

    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public static boolean isValid(String username, String password) {
        return username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD);
    }

    public static void main(String[] args) {
        // Test the isValid method
        if (isValid("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}