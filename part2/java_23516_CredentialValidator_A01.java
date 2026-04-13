public class java_23516_CredentialValidator_A01 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String username = credential.getIdentifier();
        char[] password = credential.getCredentials();

        // check password strength
        boolean hasNumber = false, hasUpperCase = false, hasLowerCase = false, hasSpecialChar = false;
        for (char c : password) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.contains(Character.toString(c))) {
                hasSpecialChar = true;
            }
            if (hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar) {
                break;
            }
        }

        // check password strength
        return hasNumber && hasUpperCase && hasLowerCase && hasSpecialChar;
    }
}