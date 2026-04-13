public class java_23894_CredentialValidator_A08 {
    // Simple credential validation. This is a very basic form of security and should not be used in production.
    public static boolean validateCredentials(String username, String password) {
        // Assume a simple username/password match. This is not secure for real use cases.
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validation
        if (validateCredentials("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}