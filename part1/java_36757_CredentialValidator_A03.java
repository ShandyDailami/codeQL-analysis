public class java_36757_CredentialValidator_A03 {
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                hasSpecialChar = true;
            }

            if (hasLowerCase && hasUpperCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }
}