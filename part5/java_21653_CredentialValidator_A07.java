public class java_21653_CredentialValidator_A07 implements CredentialValidator {
    // Fields for storing password and salt
    private String password;
    private String salt;

    // Constructor for the validator
    public java_21653_CredentialValidator_A07(String password, String salt) {
        this.password = password;
        this.salt = salt;
    }

    // Overriding the validate method
    @Override
    public boolean validate(Credential credential) throws AuthenticationFailed {
        // Get the provided password and salt
        String providedPassword = credential.getPassword();
        String providedSalt = credential.getSalt();

        // Verify the salt and password
        if (!this.salt.equals(providedSalt) || !this.password.equals(providedPassword)) {
            throw new AuthenticationFailed("Invalid password or salt");
        }

        // If the password is correct, return true
        return true;
    }
}