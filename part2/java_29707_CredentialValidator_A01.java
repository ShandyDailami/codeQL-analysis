public class java_29707_CredentialValidator_A01 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isValidPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        SecureCredentialValidator validator = new SecureCredentialValidator();

        System.out.println(validator.isValidPassword("Password@123")); // Should print true
        System.out.println(validator.isValidPassword("password")); // Should print false
        System.out.println(validator.isValidPassword("")); // Should print false
        System.out.println(validator.isValidPassword(null)); // Should print false
    }
}