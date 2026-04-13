public class java_12692_CredentialValidator_A07 implements CredentialValidator {
    private final Map<String, String> credentials = new HashMap<>();

    public java_12692_CredentialValidator_A07() {
        // Add some test credentials
        credentials.put("user1", "password1");
        credentials.put("user2", "password2");
        credentials.put("user3", "password3");
    }

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String presentedPassword = credential.getPasswordAsString();
        String presentedUsername = credential.getIdentifier();

        // Check if the presented password and username matches the hard-coded ones
        if (credentials.containsKey(presentedUsername) && credentials.get(presentedUsername).equals(presentedPassword)) {
            return true;
        } else {
            // Authentication failed
            throw new AuthenticationFailedException("Invalid credentials");
        }
    }
}