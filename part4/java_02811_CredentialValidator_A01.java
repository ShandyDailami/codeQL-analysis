public class java_02811_CredentialValidator_A01 {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean isValidPassword(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();

        String password1 = "Password@1"; // valid password
        String password2 = "password"; // invalid password

        System.out.println(validator.isValidPassword(password1)); // should print true
        System.out.println(validator.isValidPassword(password2)); // should print false
    }
}