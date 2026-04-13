public class java_30688_CredentialValidator_A08 implements CredentialValidator {

    @Override
    public boolean validate(UsernamePasswordCredential token) {
        String username = token.getIdentifier();
        // check if username is not null or empty
        if (username == null || username.isEmpty()) {
            return false;
        }
        // check if username contains any special characters
        for (char c : username.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

}