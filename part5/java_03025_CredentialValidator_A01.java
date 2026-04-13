public class java_03025_CredentialValidator_A01 {
    // Hard-coded credentials for testing
    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    // This method checks if the provided username and password match the hard-coded credentials
    public static boolean isValid(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    public static void main(String[] args) {
        // Check if the credentials are valid
        if (isValid("test", "test")) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}