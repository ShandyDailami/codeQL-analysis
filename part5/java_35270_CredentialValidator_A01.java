public class java_35270_CredentialValidator_A01 implements CredentialValidator {

    // A set of common passwords
    private static final Set<String> COMMON_PASSWORDS = new HashSet<>();
    static {
        COMMON_PASSWORDS.add("password");
        COMMON_PASSWORDS.add("123456");
        COMMON_PASSWORDS.add("111111");
        // add more common passwords here...
    }

    @Override
    public boolean validate(CredentialContext credentialContext) throws CredentialValidationException {
        String presentedPassword = credentialContext.getCredential().get("password").toString();
        if (presentedPassword == null || presentedPassword.isEmpty()) {
            throw new CredentialValidationException("No password presented");
        }

        // Check if password is common
        if (COMMON_PASSWORDS.contains(presentedPassword)) {
            throw new CredentialValidationException("Password is a common password");
        }

        // Check if password is strong enough
        if (!isPasswordStrong(presentedPassword)) {
            throw new CredentialValidationException("Password is not strong enough");
        }

        return true;
    }

    // Method to check if password is strong enough
    private boolean isPasswordStrong(String password) {
        // Assuming strong enough if it contains at least one number, one uppercase letter, one lowercase letter, and one special character
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[0-9a-zA-Z@#$%^&*]{8,}$");
    }

}