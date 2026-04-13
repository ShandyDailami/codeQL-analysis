public class java_04502_CredentialValidator_A03 {

    private static final String SPECIAL_CHARS = "!@#$%^&*()";
    private static final String NUMBER = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        if (!containsDigit(password)) {
            return false;
        }

        if (!containsLowercase(password)) {
            return false;
        }

        if (!containsUppercase(password)) {
            return false;
        }

        if (!containsSpecialChars(password)) {
            return false;
        }

        return true;
    }

    private boolean containsDigit(String password) {
        return password.matches(".*" + NUMBER + ".*");
    }

    private boolean containsLowercase(String password) {
        return password.matches(".*" + LOWERCASE + ".*");
    }

    private boolean containsUppercase(String password) {
        return password.matches(".*" + UPPERCASE + ".*");
    }

    private boolean containsSpecialChars(String password) {
        return password.matches(".*" + SPECIAL_CHARS + ".*");
    }
}