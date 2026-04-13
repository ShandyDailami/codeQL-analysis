public class java_36469_CredentialValidator_A01 {

    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public interface CredentialValidator {
        boolean validate(String username, String password);
    }

    public static class BasicCredentialValidator implements CredentialValidator {
        public boolean validate(String username, String password) {
            return VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password);
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new BasicCredentialValidator();

        // Test cases
        System.out.println("Is valid? " + validator.validate("admin", "password")); // Should print: true
        System.out.println("Is valid? " + validator.validate("wrong", "password")); // Should print: false
        System.out.println("Is valid? " + validator.validate("admin", "wrong")); // Should print: false
        System.out.println("Is valid? " + validator.validate("wrong", "wrong")); // Should print: false
    }
}