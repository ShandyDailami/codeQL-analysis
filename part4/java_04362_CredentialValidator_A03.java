public class java_04362_CredentialValidator_A03 {
    private static final String SPECIAL_CHARACTERS = "~`!@#$%^&*()_+=-";

    public static boolean isPasswordStrong(String password) {
        if (password == null) {
            return false;
        }

        // At least one uppercase letter, one lowercase letter, one digit, one special character, and at least 8 characters
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[" + SPECIAL_CHARACTERS + "]).{8,}$") &&
                !password.equals(password.toLowerCase()) && !password.equals(password.toUpperCase()) &&
                !password.equals(password.replaceAll("[0-9]", "")) && !password.equals(password.replaceAll("[^a-zA-Z0-9]", "")) &&
                !password.equals(password.replaceAll("[^A-Za-z]", "")) && !password.equals(password.replaceAll("[^0-9]", "")) &&
                !password.equals(password.replaceAll("[^" + SPECIAL_CHARACTERS + "]", ""))) {
            return true;
        }

        return false;
    }
}