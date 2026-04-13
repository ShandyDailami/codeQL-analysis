public class java_32179_CredentialValidator_A03 {

    // Method to check if password meets requirements
    public static boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password must not be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean digit = false, uppercase = false, special = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digit = true;
            } else if (Character.isUpperCase(c)) {
                uppercase = true;
            } else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".contains(String.valueOf(c))) {
                special = true;
            }
            if (digit && uppercase && special) {
                return true;
            }
        }

        return false;
    }

}