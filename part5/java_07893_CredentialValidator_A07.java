public class java_07893_CredentialValidator_A07 {

    // Predefined credentials
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to check if the given username and password match the predefined credentials
    public static boolean isValid(String username, String password) {
        return username.equals(USERNAME) && password.equals(PASSWORD);
    }

    // Main method for testing
    public static void main(String[] args) {
        String testUsername = "user";
        String testPassword = "wrongPassword";

        if (isValid(testUsername, testPassword)) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}