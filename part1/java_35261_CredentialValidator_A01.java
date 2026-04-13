public class java_35261_CredentialValidator_A01 implements CredentialValidator {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+=-[]{};:'\",.<>?/\\|`~";

    @Override
    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (SPECIAL_CHARACTERS.contains(c + "")) {
                hasSpecialCharacter = true;
            }

            if (hasNumber && hasUpperCase && hasLowerCase && hasSpecialCharacter) {
                return true;
            }
        }

        return false;
    }
}