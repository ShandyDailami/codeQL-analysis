public class java_38710_CredentialValidator_A03 {

    private static final String STRONG_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean isPasswordStrong(String password) {
        return password.matches(STRONG_PASSWORD_PATTERN);
    }

    public static boolean isUsernameValid(String username) {
        // A simple check to make sure the username is not null or empty
        return !(username == null || username.isEmpty());
    }

    public static boolean validateCredentials(String username, String password) {
        if (!isUsernameValid(username)) {
            System.out.println("Invalid username");
            return false;
        }

        if (!isPasswordStrong(password)) {
            System.out.println("Password is not strong enough");
            return false;
        }

        System.out.println("Credentials validated successfully");
        return true;
    }

    public static void main(String[] args) {
        validateCredentials("admin", "Password@123");
    }
}