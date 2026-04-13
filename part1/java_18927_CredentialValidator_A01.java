public class java_18927_CredentialValidator_A01 {

    // Method to validate a password
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;

        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(ch)) {
                hasLowerCase = true;
           
            } else if (!Character.isAlphabetic(ch)) {
                hasSpecialChar = true;
            }

            if (hasUpperCase && hasLowerCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}