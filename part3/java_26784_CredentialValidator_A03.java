public class java_26784_CredentialValidator_A03 implements CredentialValidator {
    // User object to hold user details
    private User user;

    public java_26784_CredentialValidator_A03(User user) {
        this.user = user;
    }

    @Override
    public boolean validate(Credential c) {
        // Get the username and password from the credential
        String username = c.getUsername();
        String password = c.getPassword();

        // Verify the user details with the user object
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }
}