public class java_17087_CredentialValidator_A01 {

    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean isValidPassword(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("password123") ? "Valid" : "Invalid"); // Valid
        System.out.println(isValidPassword("password") ? "Valid" : "Invalid"); // Invalid
    }
}