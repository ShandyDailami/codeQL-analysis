public class java_33441_CredentialValidator_A07 {
    // Method to validate username and password
    public static boolean validate(String username, String password) {
        // Assume we have a database for storing credentials
        // This is a simple example and might not be secure
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test the validate method
        String username = "admin";
        String password = "password";
        if (validate(username, password)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}