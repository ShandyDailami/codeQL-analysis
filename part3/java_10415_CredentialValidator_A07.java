import java.security.InvalidParameterException;

public class java_10415_CredentialValidator_A07 implements CredentialValidator {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=";
    private static final String NUMBERS = "0123456789";

    @Override
    public boolean validate(String username, String password) {
        if (password == null || password.isEmpty()) {
            throw new InvalidParameterException("Password must not be null or empty");
        }

        boolean hasNumber = false, hasUpperCase = false, hasLowerCase = false, hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (NUMBERS.contains(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.contains(c)) {
                hasSpecialCharacter = true;
            }

            if (hasNumber && hasUpperCase && hasLowerCase && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }

}