public class java_35923_CredentialValidator_A01 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("correctPassword"));
    }
}

class CredentialValidator {
    private static final String SECRET = "correctPassword";

    public boolean validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("password cannot be null");
        }
        return password.equals(SECRET);
    }
}