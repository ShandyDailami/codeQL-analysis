public class java_24653_CredentialValidator_A01 implements CredentialValidator {

    private static final String EMPTY = "";

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) {
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        if (EMPTY.equals(username) || EMPTY.equals(password)) {
            System.out.println("Username or password is empty");
            return false;
        }

        // Continue with further validation...

        return true;
    }
}