public class java_37701_CredentialValidator_A01 {

    public static boolean validateCredentials(String username, String password) {
        // Assume that username and password are correct when they are not null
        if (username == null || password == null) {
            return false;
        }

        // Simulate a check by comparing the username and password with a predefined value
        String correctUsername = "admin";
        String correctPassword = "password";
        return username.equals(correctUsername) && password.equals(correctPassword);
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "password")); // Should print true
        System.out.println(validateCredentials("wrong", "username")); // Should print false
    }
}