import javax.security.auth.credential.Credential;
import javax.security.auth.credential.CredentialException;

public class java_11045_CredentialValidator_A03 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+{}|:<>?[];',./~`";

    @Override
    public boolean validate(Credential credential) throws CredentialException {
        String password = credential.getPassword();
        if (password == null) {
            throw new CredentialException("Password cannot be null");
        }
        if (password.length() < 8) {
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