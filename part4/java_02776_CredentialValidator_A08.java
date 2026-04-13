public class java_02776_CredentialValidator_A08 {
    private String correctUsername;
    private String correctPassword;

    // Constructor
    public java_02776_CredentialValidator_A08(String correctUsername, String correctPassword) {
        this.correctUsername = correctUsername;
        this.correctPassword = correctPassword;
    }

    // Method to authenticate the user
    public boolean authenticate(String username, String password) {
        // Compare the correct username and password with the provided username and password
        // If they match, return true, otherwise return false
        return correctUsername.equals(username) && correctPassword.equals(password);
    }

    // Method to validate the user
    public boolean validate(javax.security.auth.CredentialValidatorContext context, javax.security.auth.UsernamePasswordCredential credential) throws javax.security.auth.AuthenticationException {
        // Call the authenticate method with the correctUsername and correctPassword
        // If the authenticate method returns true, return true, otherwise throw an AuthenticationException
        if (authenticate(credential.getIdentifier(), credential.getPassword())) {
            throw new javax.security.auth.AuthenticationException("Integrity failure");
        }
        return true;
    }
}