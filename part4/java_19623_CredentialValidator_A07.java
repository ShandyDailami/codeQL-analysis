public class java_19623_CredentialValidator_A07 implements CredentialValidator {

    private HashMap<String, String> credentials = new HashMap<>();

    public java_19623_CredentialValidator_A07() {
        // Initialize your credentials here.
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getPasswordAsString();
        String presentedUsername = credential.getIdentifier();

        // Check if the presented password is correct for the presented username.
        if (presentedPassword.equals(credentials.get(presentedUsername))) {
            return true;
        } else {
            throw new AuthenticationFailedException("Invalid Credentials");
        }
    }
}