public class java_00227_CredentialValidator_A03 {

    private static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean isValidEmail(String email) {
        return email.matches(EMAIL_PATTERN);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        String email = "test@example.com";
        String password = "Test@1234";

        if (!isValidEmail(email)) {
            System.out.println("Invalid email format");
        } else if (!isValidPassword(password)) {
            System.out.println("Invalid password format");
        } else {
            System.out.println("Email and password are valid");
        }
    }
}