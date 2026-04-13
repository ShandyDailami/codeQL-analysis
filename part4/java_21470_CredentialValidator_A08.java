public class java_21470_CredentialValidator_A08 {

    // The predefined pattern for the password.
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidPassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@123")); // True
        System.out.println(isValidPassword("password")); // False
    }
}