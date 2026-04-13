public class java_11139_CredentialValidator_A01 {
    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public static interface Credentials {
        String getUsername();
        String getPassword();
    }

    public static CredentialsValidator createValidator() {
        return new CredentialsValidator() {
            @Override
            public boolean validate(String username, String password) {
                return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
            }

            @Override
            public void validate(Credentials credentials, boolean result) {
                // no-op
            }
        };
    }

    public interface CredentialsValidator {
        boolean validate(String username, String password);
        void validate(Credentials credentials, boolean result);
    }
}