public class java_22953_CredentialValidator_A01 {

    // A strong password is at least 8 characters long, contains at least one uppercase letter,
    // one lowercase letter, one digit, and one special character.
    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,}$";

    private static final Pattern passwordPattern = Pattern.compile(PASSWORD_PATTERN);

    public static boolean isValidPassword(String password) {
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println(isValidPassword("Password@123")); // true
        System.out.println(isValidPassword("password")); // false
    }
}