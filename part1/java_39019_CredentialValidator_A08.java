import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class java_39019_CredentialValidator_A08 {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "~!@#%^&*()_=-{}[]|\\:<>,.?/;";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = contains(password, UPPERCASE);
        boolean hasLowerCase = contains(password, LOWERCASE);
        boolean hasDigit = contains(password, DIGITS);
        boolean hasSpecialCharacter = contains(password, SPECIAL_CHARACTERS);

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter)) {
            return false;
        }

        return true;
    }

    private boolean contains(String str, String characters) {
        for (char c : characters.toCharArray()) {
            if (str.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        CredentialValidator validator = new CredentialValidator();
        SecureRandom random = new SecureRandom();
        String password = randomPassword(8, 15);
        System.out.println("Password: " + password);
        System.out.println("Is valid: " + validator.validate(password));
    }

    private static String randomPassword(int minLength, int maxLength) {
        SecureRandom random = new SecureRandom();
        String characters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        int passwordLength = random.nextInt((maxLength - minLength) + 1) + minLength;
        StringBuilder password = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }
        return password.toString();
    }
}