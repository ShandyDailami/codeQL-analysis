public class java_09610_CredentialValidator_A08 {

    private static final String PASSWORD_REGEX = "password"; // This should be replaced with your actual regex

    public boolean validatePassword(String password) {
        return password.matches(PASSWORD_REGEX);
    }

    public static void main(String[] args) {
        PasswordValidator validator = new PasswordValidator();
        String password = "myPassword"; // This should be replaced with your actual password

        if (validator.validatePassword(password)) {
            System.out.println("Password is valid");
        } else {
            System.out.println("Password is not valid");
        }
    }
}