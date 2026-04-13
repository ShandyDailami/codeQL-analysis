public class java_29053_CredentialValidator_A08 {

    // Predefined password criteria
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String NUMBER = "0123456789";

    public boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (!hasNumber(password) || !hasSpecialCharacter(password)) {
            return false;
        }

        return true;
    }

    private boolean hasNumber(String password) {
        for (char c : password.toCharArray()) {
            if (NUMBER.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpecialCharacter(String password) {
        for (char c : password.toCharArray()) {
            if (SPECIAL_CHARACTERS.contains(Character.toString(c))) {
                return true;
            }
        }
        return false;
    }
}