public class java_09363_CredentialValidator_A01 {

    private static final String EXPECTED_USERNAME = "admin";
    private static final String EXPECTED_PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        return username.equals(EXPECTED_USERNAME) && password.equals(EXPECTED_PASSWORD);
    }

    public static void main(String[] args) {
        // Test with valid credentials
        if (validate("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }

        // Test with invalid credentials
        if (validate("invalid", "invalid")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}