public class java_14148_CredentialValidator_A07 implements CredentialValidator {

    // Hard-coded set of credentials
    private String username = "admin";
    private String password = "password";

    @Override
    public boolean validate(Credential credential) throws AuthenticationFailed {
        // Extract username and password from the Credential object
        String inputUsername = credential.getIdentifier();
        char[] inputPassword = credential.getCredential();

        // Validate the username and password
        if (username.equals(inputUsername) && validatePassword(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // Simple function to validate password (not recommended for real-world applications)
    private boolean validatePassword(char[] inputPassword) {
        String correctPassword = "password";
        // This is a very simple way to validate passwords. In a real-world application,
        // you should use a stronger algorithm and securely store passwords.
        return Arrays.equals(inputPassword, correctPassword.toCharArray());
    }
}