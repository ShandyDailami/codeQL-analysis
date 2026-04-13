public class java_34057_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public boolean validate(UsernamePasswordCredential credential) {
        String password = credential.getPasswordAsString();

        // check password length
        if (password.length() < 8) {
            return false;
        }

        // check for at least one digit, one upper case letter, one lower case letter, and one special character
        boolean hasDigit = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
            if (hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar) {
                break;
            }
        }

        // if all checks pass, return true
        return hasDigit && hasUpperCase && hasLowerCase && hasSpecialChar;
    }
}