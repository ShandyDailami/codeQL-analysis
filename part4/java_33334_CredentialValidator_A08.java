public class java_33334_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws CredentialException {
        String username = credential.getIdentifier();
        char[] password = credential.getCredential();

        if (!isPasswordStrong(password)) {
            throw new CredentialException("Password is weak. Password should be strong. (Contains uppercase, lowercase, special characters, and numbers)");
        }

        return true;
    }

    private boolean isPasswordStrong(char[] password) {
        if (password == null) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        boolean hasNumber = false;

        for (char c : password) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                hasSpecialChar = true;
            } else if (Character.getNumericValue(c) >= 0) {
                hasNumber = true;
            }

            if (hasUpperCase && hasLowerCase && hasSpecialChar && hasNumber) {
                return true;
            }
        }

        return false;
    }
}