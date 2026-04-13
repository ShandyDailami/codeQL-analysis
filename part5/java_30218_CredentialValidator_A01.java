public class java_30218_CredentialValidator_A01 implements CredentialValidator {

    private final String hardCodedUsername;
    private final String hardCodedPassword;

    public java_30218_CredentialValidator_A01(String hardCodedUsername, String hardCodedPassword) {
        this.hardCodedUsername = hardCodedUsername;
        this.hardCodedPassword = hardCodedPassword;
    }

    @Override
    public boolean validate(String username, String password) {
        return username.equals(hardCodedUsername) && password.equals(hardCodedPassword);
    }

}