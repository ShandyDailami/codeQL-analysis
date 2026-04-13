public class java_28512_CredentialValidator_A08 implements CredentialValidator {

    // This is a dummy list of valid usernames
    private List<String> validUsernames = Arrays.asList("alice", "bob", "charlie", "dave");

    @Override
    public boolean validate(UsernamePasswordCredential token) {
        String presentedPassword = token.getCredentials();
        String presentedUsername = token.getIdentity().toString();

        // Check if the presented password matches a valid username
        return validUsernames.contains(presentedUsername);
    }
}