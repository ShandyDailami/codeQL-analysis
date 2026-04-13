public class java_20063_CredentialValidator_A03 {
    public static boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

        // Checking for minimum length
        if (password.length() < 10) {
            return false;
        }

        // Checking for upper case letters
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                hasUpperCase = true;
                break;
            }
        }

        // Checking for lower case letters
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                hasLowerCase = true;
                break;
            }
        }

        // Checking for digits
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                hasDigit = true;
                break;
            }
        }

        // Checking for special characters
        for (int i = 0; i < password.length(); i++) {
            if (!(password.charAt(i) >= 'a' && password.charAt(i) <= 'z' || 
                password.charAt(i) >= 'A' && password.charAt(i) <= 'Z' || 
                password.charAt(i) >= '0' && password.charAt(i) <= '9')) {
                hasSpecialChar = true;
                break;
            }
        }

        return (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar);
    }
}