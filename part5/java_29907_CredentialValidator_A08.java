public class java_29907_CredentialValidator_A08 implements CredentialValidator {

    private String correctPassword;

    public java_29907_CredentialValidator_A08(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    @Override
    public CredentialValidationResult validate(Credential c) throws CredentialValidationException {
        String providedPassword = c.getPasswordAsString();
        if (providedPassword.equals(correctPassword)) {
            return new CredentialValidationResult(true, false);
        } else {
            throw new CredentialValidationException("Invalid password");
        }
    }
}