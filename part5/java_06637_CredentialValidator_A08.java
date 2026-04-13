// A simple password validator.

public class java_06637_CredentialValidator_A08 {

    private static final String VALID_PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    private static final Pattern VALID_PASSWORD_PATTERN_REGEX = Pattern.compile(VALID_PASSWORD_PATTERN);

    public boolean isValidPassword(String password) {
        Matcher matcher = VALID_PASSWORD_PATTERN_REGEX.matcher(password);
        return matcher.matches();
    }

    public static void main(String[] args) {
        PasswordValidator passwordValidator = new PasswordValidator();

        System.out.println(passwordValidator.isValidPassword("Password123"));
        System.out.println(passwordValidator.isValidPassword("PASSWORD123"));
        System.out.println(passwordValidator.isValidPassword("PASSWORD123$"));
        System.out.println(passwordValidator.isValidPassword("PASSWORD"));
    }
}