public class java_10775_CredentialValidator_A01 implements CredentialValidator {

    private static final String SALT = "salt"; // This should be stored securely and randomly
    private static final String SALTED_PWD = hashPassword("salt", "password");

    private static String hashPassword(String salt, String password) {
        return MessageDigest.getInstance("SHA-256").digest((salt + password).getBytes())
                .toString();
    }

    @Override
    public boolean validate(CredentialContext credentialContext) throws CredentialValidationException {
        String presentedPassword = credentialContext.getPassword();
        String presentedUsername = credentialContext.getIdentifier();

        // For simplicity, we're just checking the password and username against static values
        // In reality, you'd likely want to use a more secure method to store passwords,
        // such as storing password hashes in a database or using a hashing algorithm
        if (!presentedPassword.equals(SALTED_PWD)) {
            throw new CredentialValidationException("Invalid password");
        }

        if (!presentedUsername.equals("admin")) {
            throw new CredentialValidationException("Invalid username");
        }

        return true;
    }

    @Override
    public boolean supports(CredentialContext credentialContext) {
        // Returns true if this validator supports the specified context
        return true;
    }
}