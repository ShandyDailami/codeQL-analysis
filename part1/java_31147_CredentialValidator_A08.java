public class java_31147_CredentialValidator_A08 {

    // Static username and password for simplicity
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        // If the provided username and password match the static values, return true
        return (username.equals(USERNAME) && password.equals(PASSWORD));
    }

    public static void main(String[] args) {
        if (validateCredentials("admin", "password")) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }
}