public class java_25663_CredentialValidator_A07 {

    // Function to check if a password is strong enough
    public static boolean isPasswordStrong(String password) {
        return password.length() > 8 && 
               password.matches(".*[a-z].*") && 
               password.matches(".*[A-Z].*") && 
               password.matches(".*[0-9].*") && 
               password.matches(".*[^a-zA-Z0-9].*");
    }

    // Function to check if a username is valid
    public static boolean isUsernameValid(String username) {
        return !username.isEmpty() && username.length() > 4;
    }

    // Function to validate credentials
    public static boolean validateCredentials(String username, String password) {
        return isUsernameValid(username) && isPasswordStrong(password);
    }

    public static void main(String[] args) {
        // Test the validator
        System.out.println(validateCredentials("user", "password"));  // Should print true
        System.out.println(validateCredentials("user", "password1"));  // Should print false
        System.out.println(validateCredentials("user", ""));  // Should print false
    }
}