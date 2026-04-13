public class java_00826_CredentialValidator_A03 implements CredentialValidator {

    // Character sets for the password requirements
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$";

    @Override
    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("password is marked non-null but was passed in");
        }

        // Check if password meets criteria
        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }
}