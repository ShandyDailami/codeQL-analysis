public class java_21752_CredentialValidator_A03 {

    // Rule 1: Username must be at least 5 characters long.
    public boolean isValidUsername(String username) {
        if (username == null || username.length() < 5) {
            return false;
        }
        return true;
    }

    // Rule 2: Password must be at least 8 characters long and must contain at least one uppercase letter, one lowercase letter, one digit, and one special character.
    public boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }
        
        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpperCase = true;
            else if (Character.isLowerCase(c)) hasLowerCase = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".contains(String.valueOf(c))) hasSpecialChar = true;
            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) break;
        }

        return !(!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialChar);
    }
}