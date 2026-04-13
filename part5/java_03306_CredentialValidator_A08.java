public class java_03306_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        // Check if password contains at least one digit
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one digit");
        }

        // Check if password contains at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter");
        }

        // Check if password contains at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter");
        }

        // Check if password contains at least one special character
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException("Password must contain at least one of the symbols $@#* and so on");
        }

        // If all checks pass, password is valid
        return true;
    }

    public static void main(String[] args) {
        validatePassword("Password@123");
    }
}