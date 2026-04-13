public class java_26221_CredentialValidator_A07 {
    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("test", "test")); // should return true
        System.out.println(validator.validate("wrong", "test")); // should return false
    }
}

class CredentialValidator {
    private static final String CORRECT_USERNAME = "test";
    private static final String CORRECT_PASSWORD = "test";

    public boolean validate(String username, String password) {
        return username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD);
    }
}