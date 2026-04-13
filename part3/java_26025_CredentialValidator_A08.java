public class java_26025_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final String NUMBERS = "0123456789";

    @Override
    public boolean validate(Credential credential) throws CredentialValidationException {
        String password = credential.getPassword();
        if (password == null) {
            throw new CredentialValidationException("Null password");
        }

        // Check if password length is at least 8
        if (password.length() < 8) {
            throw new CredentialValidationException("Password length should be at least 8");
        }

        // Check if password contains at least one uppercase, one lowercase, one special character, and one digit
        if (!(password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[" + SPECIAL_CHARACTERS + "].*") && password.matches(".*[" + NUMBERS + "].*"))) {
            throw new CredentialValidationException("Password should contain at least one uppercase, one lowercase, one special character, and one digit");
        }

        return true;
    }
}