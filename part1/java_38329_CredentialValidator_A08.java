public class java_38329_CredentialValidator_A08 {
    private static final int MIN_PASSWORD_LENGTH = 8;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public static boolean validatePassword(String password) {
        if (password == null) {
            return false;
        }

        if (password.length() < MIN_PASSWORD_LENGTH) {
            return false;
        }

        if (!password.matches(PASSWORD_PATTERN)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validatePassword("Password@123"));
    }
}