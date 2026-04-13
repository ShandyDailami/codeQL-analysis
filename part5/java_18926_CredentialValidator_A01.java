import java.security.InvalidParameterException;

public class java_18926_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()_+=-=[]\\\\|{}:;\"' <>,.?/";

    public boolean isValid(String password) {
        if (password == null) {
            throw new InvalidParameterException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        if (!hasNumber(password)) {
            return false;
        }

        if (!hasUpperCase(password)) {
            return false;
        }

        if (!hasLowerCase(password)) {
            return false;
        }

        if (!hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasNumber(String password) {
        return password.matches(".*\\d.*");
    }

    private boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}