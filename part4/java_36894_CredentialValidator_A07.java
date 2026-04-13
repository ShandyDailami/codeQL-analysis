public class java_36894_CredentialValidator_A07 implements CredentialValidator {

    // Fields
    private UserCredentials userCredentials;

    // Constructor
    public java_36894_CredentialValidator_A07(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    // CredentialValidator methods
    @Override
    public boolean validate(Credential credential) throws AuthFailure {
        String username = credential.identity;
        String password = credential.password;

        if (userCredentials.isValidUser(username, password)) {
            return true;
        } else {
            throw new AuthFailure();
        }
    }
}