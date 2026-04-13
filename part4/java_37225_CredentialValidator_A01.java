public class java_37225_CredentialValidator_A01 {

    public static boolean validatePassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }

        boolean containsPassword = password.contains("password");

        // You can add more conditions here if you want
        // For example, you can check if password contains a numeric character
        boolean containsNumeric = password.matches(".*\\d.*");

        // Check if password contains a special character
        boolean containsSpecialChar = password.matches(".*[!@#$%^&*()_+\\-={}\\[\\\];':\",.<>?].*");

        // Return false if password does not contain a password character, a numeric character, or a special character
        return !(containsPassword || containsNumeric || containsSpecialChar);
    }
}