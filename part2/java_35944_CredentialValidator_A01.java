public class java_35944_CredentialValidator_A01 {

    public static boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password length must be at least 8 characters");
        }
        // Check for other security-related conditions such as repeating characters, etc.
        return true; // If all conditions are met, return true
    }

}