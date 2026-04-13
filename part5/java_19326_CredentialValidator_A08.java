public class java_19326_CredentialValidator_A08 {

    // A constant for the minimum acceptable password length.
    private static final int MINIMUM_PASSWORD_LENGTH = 8;

    public static boolean isPasswordValid(String password) {
        // If the password is too short, it's not valid.
        if (password.length() < MINIMUM_PASSWORD_LENGTH) {
            return false;
        }

        // If the password contains only one character, it's not valid.
        if (password.length() == 1) {
            return false;
        }

        // If the password contains a sequence of the same character, it's not valid.
        for (int i = 1; i < password.length(); i++) {
            if (password.charAt(i) == password.charAt(i - 1)) {
                return false;
            }
        }

        // If the password contains the sequence "password", it's not valid.
        if (password.toLowerCase().contains("password")) {
            return false;
        }

        // If the password contains a sequence of the same character, it's not valid.
        if (password.matches(".*[a-zA-Z0-9]{2}.*")) {
            return false;
        }

        // If none of the checks fail, the password is valid.
        return true;
    }
}