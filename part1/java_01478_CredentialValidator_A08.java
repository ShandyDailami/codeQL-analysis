public class java_01478_CredentialValidator_A08 {

    public static void main(String[] args) {
        String password = "your_password_here";
        System.out.println(validatePassword(password));
    }

    private static boolean validatePassword(String password) {
        // Check password length
        if (password.length() < 8) {
            return false;
        }

        // Check for uppercase letters
        if (!hasUpperCase(password)) {
            return false;
        }

        // Check for lowercase letters
        if (!hasLowerCase(password)) {
            return false;
        }

        // Check for special characters
        if (!hasSpecialCharacter(password)) {
            return false;
        }

        // Password meets all requirements
        return true;
    }

    private static boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasSpecialCharacter(String password) {
        String specialCharacters = "!@#$%^&*()";
        for (char c : password.toCharArray()) {
            if (specialCharacters.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}