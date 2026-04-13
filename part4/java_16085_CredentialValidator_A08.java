public class java_16085_CredentialValidator_A08 {

    private static final String PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

    public boolean validate(String password) {
        return password.matches(PATTERN);
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("password123")); // This should print true
        System.out.println(validator.validate("password")); // This should print false
    }
}