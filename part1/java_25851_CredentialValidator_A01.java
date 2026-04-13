public class java_25851_CredentialValidator_A01 {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isPasswordStrong(String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Assuming user wants to input a password
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        if (validator.isPasswordStrong(password)) {
            System.out.println("The password is strong.");
        } else {
            System.out.println("The password is weak. Please enter a stronger password.");
        }
    }
}