public class java_05588_CredentialValidator_A03 implements CredentialValidator {
    private String[] validUsers;
    private String[] validPasswords;

    public java_05588_CredentialValidator_A03() {
        validUsers = new String[]{"user1", "user2", "user3"};
        validPasswords = new String[]{"password1", "password2", "password3"};
    }

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String user = credentials.getUsername();
        String password = credentials.getPassword();

        for (int i = 0; i < validUsers.length; i++) {
            if (validUsers[i].equals(user) && validPasswords[i].equals(password)) {
                return true;
            }
        }

        throw new AuthenticationException("Authentication failed");
    }
}