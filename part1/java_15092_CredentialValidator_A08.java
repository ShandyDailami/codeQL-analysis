public class java_15092_CredentialValidator_A08 {

    // A strong password must contain:
    // a mix of upper and lower case letters
    // a number
    // a special character
    // minimum of eight characters
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validate(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("Password@123")); // should print true
        System.out.println(validator.validate("password123")); // should print false
    }
}