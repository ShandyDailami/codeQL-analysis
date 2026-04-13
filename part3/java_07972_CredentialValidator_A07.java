public class java_07972_CredentialValidator_A07 implements CredentialValidator {

    @Override
    public CredentialValidationResult validate(Credential credential) throws AuthenticationException {
        String password = credential.getPassword();

        // Check password length
        if (password.length() < 8) {
            return new CredentialValidationResult("Password must be at least 8 characters long", null, false);
        }

        // Check for uppercase letter
        if (!hasUpperCase(password)) {
            return new CredentialValidationResult("Password must contain at least one uppercase letter", null, false);
        }

        // Check for lowercase letter
        if (!hasLowerCase(password)) {
            return new CredentialValidationResult("Password must contain at least one lowercase letter", null, false);
        }

        // Check for special character
        if (!hasSpecialChar(password)) {
            return new CredentialValidationResult("Password must contain at least one special character", null, false);
        }

        return new CredentialValidationResult("Success", null, true);
    }

    private boolean hasUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasLowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLowerCase(word.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialChar(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!(Character.isLetter(word.charAt(i)) && Character.isAlphabetic(word.charAt(i)))) {
                return true;
            }
        }
        return false;
    }
}