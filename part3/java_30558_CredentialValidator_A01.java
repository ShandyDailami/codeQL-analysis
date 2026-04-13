public class java_30558_CredentialValidator_A01 {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final int MIN_PASSWORD_LENGTH = 8;

    public boolean isValidPassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (!password.matches(PASSWORD_REGEX)) {
            return false;
        }

        return true;
    }

}