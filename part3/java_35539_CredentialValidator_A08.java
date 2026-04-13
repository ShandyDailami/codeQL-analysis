public class java_35539_CredentialValidator_A08 {
    public static boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
        }

        if (!hasDigit || !hasUpperCase || !hasLowerCase) {
            throw new IllegalArgumentException("Password must contain at least one digit, one upper case and one lower case letter");
        }

        return true;
    }
}