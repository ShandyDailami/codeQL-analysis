public class java_11635_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredentials credentials) throws AuthenticationException {
        String password = credentials.getPassword();

        // Simple rule: the password should be at least 10 characters long
        if (password.length() < 10) {
            return false;
        }

        // Simple rule: the password should contain at least one uppercase letter, one lowercase letter, and one digit
        if (!(password.matches(".*[A-Z].*")) || !(password.matches(".*[a-z].*")) || !(password.matches(".*/d.*/"))) {
            return false;
        }

        // If all rules are passed, the password is considered strong
        return true;
    }

}