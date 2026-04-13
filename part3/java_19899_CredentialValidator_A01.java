public class java_19899_CredentialValidator_A01 {
    // Function to check if the password is strong enough
    public static boolean isPasswordStrong(String password) {
        // Define a strong password as:
        // 1. At least 8 characters long
        // 2. At least one upper case letter
        // 3. At least one lower case letter
        // 4. At least one special character
        // 5. At least one digit

        // This is a simple validation and real-world applications should use more complex rules
        if (password.length() < 8) {
            return false;
        }
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        if (!password.matches(".*[0-9].*")) {
            return false;
        }
        if (!password.matches(".*[!@#$%^&*()_+\-=\\{}\\|:;\"'<,>.?].*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test the isPasswordStrong function
        System.out.println(isPasswordStrong("Password123!")); // This should print true
        System.out.println(isPasswordStrong("password")); // This should print false
    }
}