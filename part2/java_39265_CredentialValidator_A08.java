public class java_39265_CredentialValidator_A08 {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        return password.matches(PASSWORD_PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        System.out.println(validator.validate("Password123"));
        System.out.println(validator.validate("password"));
    }
}