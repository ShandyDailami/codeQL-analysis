public class java_24452_CredentialValidator_A03 {
    // Define a User object
    private User user;

    // Constructor
    public java_24452_CredentialValidator_A03(User user) {
        this.user = user;
    }

    // Method to check if the password is strong
    public boolean isPasswordStrong(String password) {
        // Assuming a password must be at least 8 characters long,
        // contain at least one digit, one uppercase letter, one lowercase letter, and one special character
        if (password.length() < 8) {
            return false;
        }

        boolean digitFound = false, lowercaseFound = false, uppercaseFound = false, specialCharFound = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitFound = true;
            } else if (Character.isLowerCase(c)) {
                lowercaseFound = true;
            } else if (Character.isUpperCase(c)) {
                uppercaseFound = true;
            } else {
                specialCharFound = true;
            }

            if (digitFound && lowercaseFound && uppercaseFound && specialCharFound) {
                return true;
            }
        }

        return false;
    }

    // Method to check if the username is unique
    public boolean isUsernameUnique(String username) {
        // Assuming a username is unique if it does not match any user's username
        return user.getUsername().equals(username);
    }

    // Main method
    public static void main(String[] args) {
        // Create a User
        User user = new User("admin", "12345678");

        // Create a CredentialValidator
        CredentialValidator validator = new CredentialValidator(user);

        // Test the methods
        System.out.println(validator.isPasswordStrong("Admin12345678")); // should return true
        System.out.println(validator.isUsernameUnique("admin")); // should return true
    }
}