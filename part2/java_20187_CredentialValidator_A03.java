public class java_20187_CredentialValidator_A03 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        // Test the password validator
        String password = "Password@123";
        if (validatePassword(password)) {
            System.out.println("Valid password");
        } else {
            System.out.println("Invalid password");
        }
    }
}