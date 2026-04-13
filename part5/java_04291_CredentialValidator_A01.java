public class java_04291_CredentialValidator_A01 implements CredentialValidator {

    private static final List<String> KNOWN_USERNAMES = Arrays.asList("user1", "user2", "admin");
    private static final List<String> KNOWN_PASSWORDS = Arrays.asList("password1", "password2", "admin");

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        String password = credential.getCredential();

        if (KNOWN_USERNAMES.contains(username) && KNOWN_PASSWORDS.contains(password)) {
            return true;
        } else {
            throw new CredentialException("Access denied for user: " + username);
        }
    }
}