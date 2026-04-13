public class java_38087_CredentialValidator_A01 implements CredentialValidator {

    // This is a simple rule that checks if the password is a string of numbers
    private static final String NUMBER_PATTERN = "[0-9]+";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws AuthenticationException {
        String password = credential.getPassword();

        // Check if the password is a string of numbers
        if (password.matches(NUMBER_PATTERN)) {
            return true; // Password matches the rule
        } else {
            return false; // Password does not match the rule
        }
    }
}