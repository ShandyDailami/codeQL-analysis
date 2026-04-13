public class java_02345_CredentialValidator_A03 implements CredentialValidator {

    // Define a set of common passwords that would not be considered strong
    private static final Set<String> WEAK_PASSWORDS = new HashSet<>(Arrays.asList("123456", "password", "admin", "qwerty"));

    @Override
    public boolean validate(Credential credential) throws CredentialValidationException {
        String password = credential.getPassword();

        // Check if the password is in the list of weak passwords
        if (WEAK_PASSWORDS.contains(password)) {
            throw new CredentialValidationException("Weak password detected: " + password);
        }

        // Check if the password is too short or too long
        if (password.length() < 8 || password.length() > 20) {
            throw new CredentialValidationException("Password must be between 8 and 20 characters");
        }

        // Check if the password contains at least one upper case letter, one lower case letter, and one special character
        if (!(password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*=+(?:query?=[^&\\?#$@!%^_&])?(?:<[^&\\?#$@!%^_&])?[a-zA-Z\\d@#$%^&*=+(?:query?=[^&\\?#$@!%^_&])?(?:<[^&\\?#$@!%^_&])?[\\d@#$%^&*=+(?:query?=[^&\\?#$@!%^_&])?(?:<[^&\\?#$@!%^_&])?[^&\\?#$@!%^_&])?[^&\\?#$@!%^_&])?$"))) {
            throw new CredentialValidationException("Password must contain at least one upper case letter, one lower case letter, and one special character");
        }

        return true;
    }
}