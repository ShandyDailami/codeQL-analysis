public class java_18880_CredentialValidator_A07 {
    // User data class
    static class User {
        String password;

        User(String password) {
            this.password = password;
        }
    }

    // Credential Validator
    public static boolean validate(User user, String passwordAttempt) {
        // If the passwords match, return true
        return user.password.equals(passwordAttempt);
    }

    public static void main(String[] args) {
        // Create a user with a password
        User user = new User("password");

        // Attempt to authenticate the user with the same password
        boolean isValid = validate(user, "password");

        // Print the result
        System.out.println("Is valid: " + isValid);
    }
}