import java.util.regex.Pattern;

public class java_19413_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String SPECIAL_CHARACTERS_REGEX = "[" + Pattern.quote(SPECIAL_CHARACTERS) + "]";

    public boolean isPasswordStrongEnough(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        boolean hasNumber = Pattern.matches(".*[0-9].*", password);
        boolean hasUpperCase = Pattern.matches(".*[A-Z].*", password);
        boolean hasLowerCase = Pattern.matches(".*[a-z].*", password);
        boolean hasSpecialCharacter = Pattern.matches(".*[" + SPECIAL_CHARACTERS_REGEX + "].*", password);

        if (!(hasNumber && hasUpperCase && hasLowerCase && hasSpecialCharacter)) {
            return false;
        }

        return true;
    }
}