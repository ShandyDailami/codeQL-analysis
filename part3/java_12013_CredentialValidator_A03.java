public class java_12013_CredentialValidator_A03 implements CredentialValidator {

    private static final List<String> AUTHORIZED_USERS = Arrays.asList("user1", "user2", "admin");
    private static final List<String> AUTHORIZED_PASSWORDS = Arrays.asList("pass1", "pass2", "admin");

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String user = credential.getIdentifier();
        String password = new String(credential.getCredentials());

        return AUTHORIZED_USERS.contains(user)
                && AUTHORIZED_PASSWORDS.contains(password);
    }

}