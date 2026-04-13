public class java_04706_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";

    @Override
    public boolean validate(String username, String password) {
        int count = 0;

        if (password.length() < 8) {
            return false;
        }

        if (containsLowerCase(password)) {
            count++;
        }

        if (containsUpperCase(password)) {
            count++;
        }

        if (containsDigit(password)) {
            count++;
        }

        if (containsSpecialCharacter(password)) {
            count++;
        }

        return count >= 3;
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[" + LOWERCASE + "].*");
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[" + UPPERCASE + "].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*[" + DIGITS + "].*");
    }

    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}