public class java_35587_CredentialValidator_A08 {
    public boolean validate(String username) {
        // Check if the username contains at least one uppercase letter, one lowercase letter, and one number
        boolean uppercase = false, lowercase = false, digit = false;
        for (char c : username.toCharArray()) {
            if (Character.isUpperCase(c)) uppercase = true;
            if (Character.isLowerCase(c)) lowercase = true;
            if (Character.isDigit(c)) digit = true;
            if (uppercase && lowercase && digit) return true;
        }
        return false;
    }
}