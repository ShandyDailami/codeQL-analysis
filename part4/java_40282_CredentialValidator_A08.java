public class java_40282_CredentialValidator_A08 {

    public static boolean validatePassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (!isValidSpecialCharacter(c)) {
                hasSpecialCharacter = true;
            }

            if (hasDigit && hasUpperCase && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidSpecialCharacter(char c) {
        return c != ' ' && !Character.isLetterOrDigit(c) && !Character.isUpperCase(c);
    }
}