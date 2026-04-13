import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidParameterSpecException;

public class java_34069_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBERS = "0123456789";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public boolean validate(String password) throws NoSuchAlgorithmException, InvalidParameterSpecException {

        // Check if password is too short
        if (password.length() < 8) {
            throw new InvalidParameterSpecException("Password must be at least 8 characters");
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, one number and one special character
        if (!(containsUppercase(password) && containsLowercase(password) && containsNumber(password) && containsSpecialCharacter(password)) {
            throw new InvalidParameterSpecException("Password must contain at least one uppercase letter, one lowercase letter, one number and one special character");
        }

        // If everything is OK, return true
        return true;
    }

    private boolean containsUppercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (UPPERCASE_LETTERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsLowercase(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (LOWERCASE_LETTERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsNumber(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (NUMBERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    private boolean containsSpecialCharacter(String password) {
        for (int i = 0; i < password.length(); i++) {
            if (SPECIAL_CHARACTERS.contains(String.valueOf(password.charAt(i)))) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidParameterSpecException {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("Password@123"));
    }
}