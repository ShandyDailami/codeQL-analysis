public class java_15201_CredentialValidator_A01 {

    public static class CredentialValidator implements com.example.interfaces.CredentialValidator {

        @Override
        public boolean validate(String username, String password) {
            // Check if password is at least 8 characters long
            if (password.length() < 8) {
                return false;
            }

            // If password is valid, return true
            return true;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();
        System.out.println(validator.validate("user", "password"));  // Should print: false
        System.out.println(validator.validate("user", "passwor"));  // Should print: true
    }
}