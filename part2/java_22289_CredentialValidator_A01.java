public class java_22289_CredentialValidator_A01 {

    // Rule: Password must be at least 8 characters long
    public boolean isPasswordValid(String password) {
        if (password == null) {
            return false;
        }
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    // Rule: Password must contain at least one uppercase letter, one lowercase letter, and one number
    public boolean isUsernameValid(String username) {
        if (username == null) {
            return false;
        }
        if (!username.matches("^[a-zA-Z0-9]*$")) {
            return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println("Is password valid? " + validator.isPasswordValid("password")); // Should print false
        System.out.println("Is password valid? " + validator.isPasswordValid("password1")); // Should print true
        System.out.println("Is username valid? " + validator.isUsernameValid("username")); // Should print false
        System.out.println("Is username valid? " + validator.isUsernameValid("username1")); // Should print true
    }
}