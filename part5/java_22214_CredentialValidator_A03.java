public class java_22214_CredentialValidator_A03 {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

    public static boolean isValidPassword(String password) {
        // Check if password is null or empty
        if (password == null || password.isEmpty()) {
            return false;
        }

        // Check if password length is not minimum length
        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        // Check if password contains at least one special character
        if (!password.contains(SPECIAL_CHARACTERS)) {
            return false;
        }

        // Password is valid
        return true;
    }

    public static void main(String[] args) {
        String password = "Abc123!@#";
        boolean isValid = isValidPassword(password);
        if (isValid) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}