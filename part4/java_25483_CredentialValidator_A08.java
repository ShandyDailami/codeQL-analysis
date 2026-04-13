public class java_25483_CredentialValidator_A08 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@123")); // Should print true
        System.out.println(isValidPassword("password")); // Should print false
        System.out.println(isValidPassword("PASSWORD123$")); // Should print false
        System.out.println(isValidPassword("Password@")); // Should print false
        System.out.println(isValidPassword("Password@1")); // Should print false
    }
}