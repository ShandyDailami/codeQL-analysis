public class java_29564_CredentialValidator_A07 implements CredentialValidator {
    // Constant for strong password requirements
    private static final int STRONG_PASSWORD_MIN_LENGTH = 8;
    private static final int STRONG_PASSWORD_MAX_LENGTH = 16;

    // Constant for strong password requirements
    private static final String STRONG_PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

    @Override
    public boolean validate(String username, String password, boolean userDidAuthenticate) {
        if (!userDidAuthenticate) {
            throw new IllegalStateException("Not Authenticated");
        }

        if (password.length() < STRONG_PASSWORD_MIN_LENGTH || password.length() > STRONG_PASSWORD_MAX_LENGTH) {
            return false;
        }

        if (!password.matches(STRONG_PASSWORD_REGEX)) {
            return false;
        }

        return true;
    }
}