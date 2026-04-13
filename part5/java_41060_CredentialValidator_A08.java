public class java_41060_CredentialValidator_A08 {

    private static final String PATTERN = "A08_IntegrityFailure";
    private static final int PASSWORD_LENGTH = 8;

    public boolean isValidPassword(String password) {
        if (password == null || password.length() != PASSWORD_LENGTH) {
            return false;
        }

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            if (password.charAt(i) != PATTERN.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}