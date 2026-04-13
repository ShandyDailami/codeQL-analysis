public class java_13879_CredentialValidator_A08 implements CredentialValidator {

    private String hardCodedPassword;

    public java_13879_CredentialValidator_A08(String hardCodedPassword) {
        this.hardCodedPassword = hardCodedPassword;
    }

    @Override
    public boolean validate(Credential credential) throws AuthenticationException {
        String presentedPassword = credential.getPassword();
        if (presentedPassword != null && presentedPassword.equals(hardCodedPassword)) {
            return true;
        } else {
            throw new IncorrectCredentialsException("Incorrect password");
        }
    }
}