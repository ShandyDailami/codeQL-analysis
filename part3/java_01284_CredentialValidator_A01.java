public class java_01284_CredentialValidator_A01 {

    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public boolean validatePassword(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        boolean hasUpperCase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowerCase = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecialCharacter = password.chars().anyMatch(c -> SPECIAL_CHARACTERS.indexOf(c) != -1);

        if (!(hasUpperCase && hasLowerCase && hasDigit && hasSpecialCharacter)) {
            throw new IllegalArgumentException("Password must contain at least one upper case letter, one lower case letter, one digit, and one special character");
        }

        return true;
    }
}