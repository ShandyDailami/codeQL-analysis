public class java_27583_CredentialValidator_A07 implements CredentialValidator {

    private final String hardCodedUsername;
    private final String hardCodedPassword;

    public java_27583_CredentialValidator_A07(String hardCodedUsername, String hardCodedPassword) {
        this.hardCodedUsername = hardCodedUsername;
        this.hardCodedPassword = hardCodedPassword;
    }

    @Override
    public boolean validate(String username, String password) {
        return username.equals(hardCodedUsername) && password.equals(hardCodedPassword);
    }

}