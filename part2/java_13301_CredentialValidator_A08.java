public interface CredentialValidator {
    boolean isValid(String credential);
}

public class java_13301_CredentialValidator_A08 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "¡¿@!#$!%^&*()";
    private static final String SPECIAL_CHARACTERS_REGEX = "[".concat(SPECIAL_CHARACTERS).concat("]");
    private static final String NUMBER = "0123456789";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String USERNAME_PATTERN = UPPERCASE + LOWERCASE + NUMBER + SPECIAL_CHARACTERS;
    private static final String PASSWORD_PATTERN = LOWERCASE + UPPERCASE + NUMBER + SPECIAL
            + SPECIAL_CHARACTERS;

    @Override
    public boolean isValid(String credential) {
        if (credential.matches("^" + SPECIAL_CHARACTERS_REGEX + "*$")) {
            return false;
        }
        if (!(credential.matches("^.{" + MIN_PWD_LENGTH + ",}$"))) {
            return false;
        }
        if (!(credential.matches("^[^" + SPECIAL_CHARACTERS_REGEX + "]+$"))) {
            return false;
        }
        String[] usernameParts = credential.split("@");
        if (usernameParts.length != 2) {
            return false;
        }
        if (!(usernameParts[0].matches("^[^" + SPECIAL_CHARACTERS_REGEX + "]+$"))) {
            return false;
        }
        if (!(usernameParts[1].matches("^[A-Za-z0-9@._]{" + MIN_USERNAME_LENGTH + ",}$"))) {
            return false;
        }
        return true;
    }
}