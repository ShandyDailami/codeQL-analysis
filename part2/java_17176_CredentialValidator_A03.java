public class java_17176_CredentialValidator_A03 {
    private String correctPassword;

    public java_17176_CredentialValidator_A03(String correctPassword) {
        this.correctPassword = correctPassword;
    }

    public boolean validate(String password) {
        return password.equals(correctPassword);
    }
}

public class Credential {
    private CredentialValidator credentialValidator;

    public java_17176_CredentialValidator_A03(String correctPassword) {
        this.credentialValidator = new CredentialValidator(correctPassword);
    }

    public boolean login(String password) {
        return credentialValidator.validate(password);
    }
}