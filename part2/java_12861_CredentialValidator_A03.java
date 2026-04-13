public class java_12861_CredentialValidator_A03 implements CredentialValidator {

    // Hardcoded set of rules for password strength
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final int MAX_PASSWORD_LENGTH = 16;
    private static final int MIN_NUMBERS = 2; // at least 2 digits
    private static final int MIN_LOWERCASE = 2; // at least 2 lowercase letters
    private static final int MIN_UPPERCASE = 2; // at least 2 uppercase letters
    private static final int MIN_SPECIAL_CHARACTERS = 2; // at least 2 special characters

    private int passwordLength;
    private int numbers;
    private int lowercase;
    private int uppercase;
    private int specialCharacters;

    public java_12861_CredentialValidator_A03() {
        passwordLength = MIN_PASSWORD_LENGTH;
        numbers = MIN_NUMBERS;
        lowercase = MIN_LOWERCASE;
        uppercase = MIN_UPPERCASE;
        specialCharacters = MIN_SPECIAL_CHARACTERS;
    }

    public boolean validate(String password) {
        // Check the password length
        if (password.length() < passwordLength || password.length() > MAX_PASSWORD_LENGTH) {
            return false;
        }

        // Check the password for digits, lowercase, uppercase and special characters
        if (password.matches(".*\\d.*") && password.matches(".*[a-z].*") && password.matches(".*[A-Z].*") && password.matches(".*[^a-zA-Z0-9].*")) {
            return true;
        }

        return false;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public void setMinNumbers(int numbers) {
        this.numbers = numbers;
    }

    public void setMinLowercase(int lowercase) {
        this.lowercase = lowercase;
    }

    public void setMinUppercase(int uppercase) {
        this.uppercase = uppercase;
    }

    public void setMinSpecialCharacters(int specialCharacters) {
        this.specialCharacters = specialCharacters;
    }
}