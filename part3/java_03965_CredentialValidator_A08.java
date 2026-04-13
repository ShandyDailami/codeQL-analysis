import javax.security.auth.CredentialValidator;
import javax.security.auth.PasswordChangeException;
import javax.security.auth.login.PasswordRequisite;
import javax.security.auth.login.LoginException;

public class java_03965_CredentialValidator_A08 implements CredentialValidator {

    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    @Override
    public PasswordValidationResult validate(PasswordRequisite passwordRequisite) throws LoginException {
        String password = passwordRequisite.getPasswordAsString();
        boolean hasUpper = containsUpperCase(password);
        boolean hasLower = containsLowerCase(password);
        boolean hasDigit = containsDigit(password);
        boolean hasSpecialChar = containsSpecialChar(password);
        boolean isLong = password.length() > 8;
        boolean isShort = password.length() < 4;

        if (!(hasUpper && hasLower && hasDigit && hasSpecialChar && isLong && !isShort)) {
            throw new PasswordChangeException("Password does not meet the requirements");
        }

        return new PasswordValidationResult(password);
    }

    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    private boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    private boolean containsSpecialChar(String password) {
        return password.matches(".*[" + SPECIAL_CHARACTERS + "].*");
    }
}