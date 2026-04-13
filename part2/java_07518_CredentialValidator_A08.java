public class java_07518_CredentialValidator_A08 implements CredentialValidator {

    private String username;
    private String password;

    public java_07518_CredentialValidator_A08(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean validate(CredentialContext context) {
        // You can get the username and password from the context
        String providedUsername = context.getAuthenticatedUsername();
        String providedPassword = context.getAuthenticatedPasswordAsString();

        // Compare the provided values with the ones we expect
        if (providedUsername.equals(this.username) && providedPassword.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }
}