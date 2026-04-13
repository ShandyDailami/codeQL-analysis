public class java_15155_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String username = credential.getIdentifier();
        char[] passwordChars = credential.getCredentials();

        // check for at least one lowercase letter, one uppercase letter, one number and one special character
        boolean hasLower = false, hasUpper = false, hasNumber = false, hasSpecialCharacter = false;
        for (char c : passwordChars) {
            if (LOWERCASE.contains(c + "")) hasLower = true;
            if (UPPERCASE.contains(c + "")) hasUpper = true;
            if (NUMBERS.contains(c + "")) hasNumber = true;
            if (SPECIAL_CHARACTERS.contains(c + "")) hasSpecialCharacter = true;
            if (hasLower && hasUpper && hasNumber && hasSpecialCharacter) break;
        }

        // check if all conditions are satisfied
        return hasLower && hasUpper && hasNumber && hasSpecialCharacter;
    }
}