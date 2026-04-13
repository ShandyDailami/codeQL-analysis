public class java_15520_CredentialValidator_A07 {
    public static boolean isStrongPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false, hasLowerCase = false, hasUpperCase = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialChar = true;
            }

            if (hasDigit && hasLowerCase && hasUpperCase && hasSpecialChar) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidSpecialCharacter(char c) {
        return (c == '@' || c == '#' || c == '$' || c == '%' || c == '^' || c == '&' || c == '*');
    }

    public static void main(String[] args) {
        // Testing the CredentialValidator
        String[] passwords = {"password", "Password123@", "P@$$w0rd!", "P@$$word123@", "P@$$w0rld@", "Passw0rd@"};
        for (String password : passwords) {
            System.out.println(password + ": " + (isStrongPassword(password) ? "Strong password" : "Weak password"));
        }
    }
}