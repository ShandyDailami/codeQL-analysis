import javax.security.auth.CredentialValidator;
import javax.security.auth.InvalidCredentialException;
import javax.security.auth.login.CredentialException;

public class java_25550_CredentialValidator_A01 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public String validate(String credentialId) throws CredentialException {
        // Validate the password
        if (!isPasswordStrong(credentialId)) {
            throw new InvalidCredentialException("Password does not meet the strength requirements.");
        }

        return null;
    }

    private boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean digit = false;
        boolean specialCharacter = false;

        char[] passwordArray = password.toCharArray();

        for (char c : passwordArray) {
            if (Character.isUpperCase(c)) {
                upperCase = true;
            } else if (Character.isLowerCase(c)) {
                lowerCase = true;
            } else if (Character.isDigit(c)) {
                digit = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                specialCharacter = true;
            }

            if (upperCase && lowerCase && digit && specialCharacter) {
                return true;
            }
        }

        return false;
    }
}