public class java_04506_CredentialValidator_A08 {

    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&*])[a-zA-Z0-9@#$%^&*]{8,16}$";

    public boolean isValidPassword(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Let's try some passwords
        String validPassword = "Password@123";
        String invalidPassword = "password";

        System.out.println("Is valid password: " + validator.isValidPassword(validPassword));
        System.out.println("Is valid password: " + validator.isValidPassword(invalidPassword));
    }
}