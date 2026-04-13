public class java_24491_CredentialValidator_A08 implements CredentialValidator {

    private final String SECRET = "mySecret"; // This is the secret we are checking against

    @Override
    public CredentialValidationResult validate(Credential c) throws AuthenticationException {
        String password = c.getPassword();
        if (password == null) {
            return CredentialValidationResult.failed("No password provided");
        }

        if (password.equals(SECRET)) {
            return CredentialValidationResult.success();
        } else {
            return CredentialValidationResult.failed("Invalid password");
        }
    }
}