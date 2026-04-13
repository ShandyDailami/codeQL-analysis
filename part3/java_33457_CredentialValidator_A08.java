public class java_33457_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";

    public boolean validate(String password) {
        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("Password1")); // Passes
        System.out.println(validator.validate("Password")); // Does not pass
    }
}