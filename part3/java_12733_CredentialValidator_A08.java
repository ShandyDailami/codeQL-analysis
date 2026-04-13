public class java_12733_CredentialValidator_A08 {

    public boolean validatePassword(String password) {
        // Check if password is null
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one number
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) upperCase = true;
            else if (Character.isLowerCase(c)) lowerCase = true;
            else if (Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) <= 9) number = true;
            if (upperCase && lowerCase && number) break;
        }

        // If password is strong, return true
        if (upperCase && lowerCase && number) return true;

        return false;
    }

}