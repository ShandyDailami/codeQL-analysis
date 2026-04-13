public class java_29043_CredentialValidator_A08 {
    // Check if password is long enough and contains a number and a special character
    public boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < 8) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isAlphabetic(c)) {
                hasSpecialCharacter = true;
            }
        }

        return hasNumber && hasSpecialCharacter;
    }
}