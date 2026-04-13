public class java_04676_CredentialValidator_A03 implements javax.security.auth.CredentialValidator<UsernamePasswordCredentials> {

    // The validate method is called by the authentication service to validate the credentials.
    public UsernamePasswordCredentials validate(UsernamePasswordCredentials credentials) throws java.security.AuthenticationException {

        // get credentials
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // validate username and password
        if(username.equals("admin") && password.equals("admin")) {
            return credentials;
        } else {
            throw new java.security.AuthenticationException("Invalid credentials");
        }
    }
}