public class java_07368_CredentialValidator_A03 implements CredentialValidator {

    // A regular expression for checking if the password is strong enough
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%^*?&])[A-Za-z\\d@$!%^*?&]{8,}$";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String password = credential.getPassword();
        if (password == null) {
            return false;
        }
        return matchPasswordPattern(password);
    }

    private boolean matchPasswordPattern(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}