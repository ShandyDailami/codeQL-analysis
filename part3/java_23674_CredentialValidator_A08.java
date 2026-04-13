public class java_23674_CredentialValidator_A08 {
    private static final String WEAK_PASSWORD = "Password should be at least 8 characters long and contain a mix of upper and lower case letters and numbers.";
    private static final String MEDIUM_PASSWORD = "Password should be at least 8 characters long and contain a mix of upper and lower case letters and numbers. It should also contain at least one digit and one special character.";
    private static final String STRONG_PASSWORD = "Password should be exactly 8 characters long and contain a mix of upper and lower case letters and numbers. It should also contain all upper and lower case letters, numbers and special characters.";

    public String validate(String password) {
        if (password == null) {
            return null;
        }

        if (password.length() < 8) {
            return WEAK_PASSWORD;
        }

        boolean hasDigit = false;
        boolean hasSpecialChar = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else {
                hasSpecialChar = true;
            }
        }

        if (!hasDigit || !hasLowerCase || !hasUpperCase || !hasSpecialChar) {
            return MEDIUM_PASSWORD;
        }

        return STRONG_PASSWORD;
    }
}