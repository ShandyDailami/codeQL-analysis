public class java_02139_CredentialValidator_A03 {

    public static void main(String[] args) {
        String password = "test"; // This should be obtained from user input
        if (isValidPassword(password)) {
            System.out.println("Password is valid.");
        } else {
            System.out.println("Password is not valid.");
        }
    }

    public static boolean isValidPassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password is at least 8 characters long
        if (password.length() < 8) {
            return false;
        }

        // Check if password contains at least one uppercase letter, one lowercase letter, and one special character
        if (!hasUpperCase(password) || !hasLowerCase(password) || !hasSpecialChar(password)) {
            return false;
        }

        // If all checks pass, password is valid
        return true;
    }

    public static boolean hasUpperCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasLowerCase(String password) {
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasSpecialChar(String password) {
        String specialChars = "!@#$%^&*()";
        for (char c : password.toCharArray()) {
            if (specialChars.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}