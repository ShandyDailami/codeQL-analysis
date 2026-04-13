public class java_36808_CredentialValidator_A01 {

    private String expectedPassword;

    public java_36808_CredentialValidator_A01(String expectedPassword) {
        this.expectedPassword = expectedPassword;
    }

    public CredentialResult validate(Credential credential) {
        String password = credential.getPassword();

        if (password.equals(this.expectedPassword)) {
            return CredentialResult.CREDENTIAL_VALID;
        } else {
            return CredentialResult.INVALID_NOT_ENABLED;
        }
    }
}