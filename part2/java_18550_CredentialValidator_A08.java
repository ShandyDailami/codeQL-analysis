public class java_18550_CredentialValidator_A08 {
    // A pattern for the password
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    // Main method to test
    public static void main(String[] args) {
        String password = "Sample@123";
        System.out.println(isValidPassword(password));
    }

    // Method to check if a password is valid
    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}