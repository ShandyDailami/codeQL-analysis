public class java_02779_CredentialValidator_A08 implements CredentialValidator {

    private static final String STRONG_PASSWORD_PATTERN = 
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String password = credential.getPassword();

        if (password == null) {
            throw new IllegalStateException("Undefined user");
        }

        return password.matches(STRONG_PASSWORD_PATTERN);
    }
}