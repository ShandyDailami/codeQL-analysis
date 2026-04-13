public class java_14933_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean validate(String password) {
        if (password == null || password.length() == 0) {
            return false;
        }

        boolean hasUpperCase = hasUpperCase(password);
        boolean hasLowerCase = hasLowerCase(password);
        boolean hasDigit = hasDigit(password);
        boolean hasSpecialCharacter = hasSpecialCharacter(password);

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter;
    }

    private static boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.getNumericValue(c) >= 0 && Character.getNumericValue(c) <= 9) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }
}