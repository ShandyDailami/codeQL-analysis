import java.security.SecureRandom;

public class java_14052_CredentialValidator_A08 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";

    public static boolean validate(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = UPPERCASE_LETTERS.contains(password.substring(0, 1));
        boolean hasLowerCase = LOWERCASE_LETTERS.contains(password.substring(1, 2));
        boolean hasDigit = DIGITS.contains(password.substring(2, 3));
        boolean hasSpecialCharacter = SPECIAL_CHARACTERS.contains(password.substring(3, 4));

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter;
    }

    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        String password = generatePassword(8);
        System.out.println("Generated Password: " + password);

        boolean isValid = validate(password);
        System.out.println("Is Valid Password: " + isValid);
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        password.append(UPPERCASE_LETTERS.charAt(random.nextInt(UPPERCASE_LETTERS.length())));
        password.append(LOWERCASE_LETTERS.charAt(random.nextInt(LOWERCASE_LETTERS.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        for (int i = 4; i < length; i++) {
            password.append(random.nextInt(10));
        }

        return password.toString();
    }
}