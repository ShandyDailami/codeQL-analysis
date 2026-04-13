import javax.security.auth.AuthFailureure;
import javax.security.auth.login.CredentialValidationResult;
import javax.security.auth.login.LoginException;
import javax.security.auth.validation.ValidationResult;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class java_31630_CredentialValidator_A07 {

    private static final Set<Character> SPECIAL_CHARACTERS = new HashSet<>(Arrays.asList('@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '+', '<', '>', '?', '/'));
    private static final Set<Character> UPPERCASE_LETTERS = new HashSet<>();
    private static final Set<Character> LOWERCASE_LETTERS = new HashSet<>();
    private static final Set<Character> DIGITS = new HashSet<>();

    static {
        for (char c = '0'; c <= '9'; c++)
            DIGITS.add(c);
        for (char c = 'a'; c <= 'z'; c++)
            LOWERCASE_LETTERS.add(c);
        for (char c = 'A'; c <= 'Z'; c++)
            UPPERCASE_LETTERS.add(c);
    }

    public CredentialValidationResult validate(javax.security.auth.Credential cred) throws LoginException {
        String password = (String) cred.getCredential();

        if (password.length() < 8)
            return new CredentialValidationResult("Password length should be at least 8", null);

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(c))
                hasSpecialChar = true;
            if (isDigit(c))
                hasDigit = true;
            if (isUpperCase(c))
                hasUpperCase = true;
            if (isLowerCase(c))
                hasLowerCase = true;
        }

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar))
            throw new AuthFailureure("Invalid password: Password must contain one upper case, one lower case, one digit, and one special character");

        return new CredentialValidationResult("Validated successfully", null);
    }

    private boolean isUpperCase(char c) {
        return UPPERCASE_LETTERS.contains(c);
    }

    private boolean isLowerCase(char c) {
        return LOWERCASE_LETTERS.contains(c);
    }

    private boolean isDigit(char c) {
        return DIGITS.contains(c);
    }
}