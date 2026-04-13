public class java_23728_CredentialValidator_A08 implements CredentialValidator {

    private final String correctUsername;
    private final String correctPassword;

    public java_23728_CredentialValidator_A08(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    @Override
    public boolean validate(String username, String password) {
        return username.equals(correctUsername) && password.equals(correctPassword);
    }
}