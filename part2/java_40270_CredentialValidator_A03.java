import java.util.regex.Pattern;

public class java_40270_CredentialValidator_A03 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "~`^@\\{|}$";
    private static final String SPECIAL_CHARACTERS_REGEX = "[" + Pattern.quote(SPECIAL_CHARACTERS) + "]";

    @Override
    public boolean isPasswordStrong(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (password.matches(".*[0-9].*")) {
            return false;
        }

        if (password.matches(".*[a-z].*")) {
            return false;
        }

        if (password.matches(".*[A-Z].*")) {
            return false;
        }

        if (password.matches(SPECIAL_CHARACTERS_REGEX)) {
            return false;
        }

        return true;
    }
}