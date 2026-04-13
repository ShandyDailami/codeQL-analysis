public class java_24090_CredentialValidator_A01 implements CredentialValidator {

    // Hard-coded username and password for simplicity
    private final String USERNAME = "admin";
    private final String PASSWORD = "password";

    @Override
    public CredentialValidationResult validate(CredentialContext credentialContext) {
        String presentedUsername = credentialContext.get presentedUsername();
        String presentedPassword = credentialContext.getPresentedPassword();

        // Check if the presented username and password match with hard-coded values
        if (USERNAME.equals(presentedUsername) && PASSWORD.equals(presentedPassword)) {
            return new CredentialValidationResult(true, credentialContext);
        } else {
            return new CredentialValidationResult(false, credentialContext);
        }
    }
}