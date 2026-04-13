public class java_13313_CredentialValidator_A08 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+<>?_=";

    @Override
    public boolean validate(UsernamePasswordCredential credential) throws InvalidCredentialException {
        String password = credential.getPasswordAsString();

        // Check length of password
        if (password.length() < 8) {
            throw new InvalidCredentialException("Password must be at least 8 characters long");
        }

        // Check for special characters
        if (!hasSpecialCharacter(password)) {
            throw new InvalidCredentialException("Password must contain a special character");
        }

        // Check for numeric digit
        if (!hasNumericDigit(password)) {
            throw new InvalidCredentialException("Password must contain a numeric digit");
        }

        return true;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasNumericDigit(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}