public class java_29218_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";

    public static boolean validate(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false, hasLowerCase = false, hasDigit = false, hasSpecialChar = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
            if (hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("Password123!")); // returns true
        System.out.println(validate("password123!")); // returns false
    }
}