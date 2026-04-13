public class java_41210_CredentialValidator_A07 {

    public static void main(String[] args) {
        String[] passwords = {"password", "123456", "abcdef", "admin", "qwerty"};
        CredentialValidator validator = new CredentialValidator(passwords);

        System.out.println("Is valid: " + validator.isValid("password"));
        System.out.println("Is valid: " + validator.isValid("wrongpassword"));
    }

    // No need for CredentialValidator in a non-legacy style
    private static class CredentialValidator {
        private String[] passwords;

        public java_41210_CredentialValidator_A07(String[] passwords) {
            this.passwords = passwords;
        }

        public boolean isValid(String password) {
            for (String p : passwords) {
                if (p.equals(password)) {
                    return true;
                }
            }
            return false;
        }
    }
}