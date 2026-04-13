public class java_15711_CredentialValidator_A07 {

    public static boolean validate(String username, String password) {
        // Simple check for username and password
        // Replace this with your own security-sensitive operations
        if (username == null || password == null) {
            return false;
        }

        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validator
        if (validate("admin", "password")) {
            System.out.println("Authentication successful");
        } else {
            System.out.println("Authentication failed");
        }
    }
}