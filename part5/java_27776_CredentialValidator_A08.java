public class java_27776_CredentialValidator_A08 {

    // Simplified CredentialValidator for the purpose of this example
    public static boolean validateCredentials(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // In a real-world application, you should use a secure method to compare the passwords
        // Here we're comparing the passwords as plain text for simplicity
        if (username.equals("admin") && password.equals("password")) {
            return true;
        } else {
            return false;
        }
    }

    // Example main method for testing
    public static void main(String[] args) {
        if (validateCredentials("admin", "password")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}