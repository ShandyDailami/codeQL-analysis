public class java_26459_CredentialValidator_A07 {
    public static void main(String[] args) {
        validateCredentials("admin", "password");
    }

    private static void validateCredentials(String username, String password) {
        String expectedUsername = "admin";
        String expectedPassword = "password";

        if (!username.equals(expectedUsername) || !password.equals(expectedPassword)) {
            System.out.println("Invalid username or password. Please try again.");
            return;
        }

        System.out.println("Access granted.");
    }
}