public class java_28304_CredentialValidator_A08 {

    public static class Credential {
        private String username;
        private String password;

        public java_28304_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    public static class CredentialValidatorImpl implements CredentialValidator {
        @Override
        public boolean isValid(Credential credential) {
            String password = credential.getPassword();
            boolean isValid = (password != null && password.length() >= 8);

            if (isValid) {
                isValid = (password.matches(".*[a-z].*"));
            }

            if (isValid) {
                isValid = (password.matches(".*[A-Z].*"));
            }

            if (isValid) {
                isValid = (password.matches(".*[0-9].*"));
            }

            if (isValid) {
                isValid = (password.matches(".*[#|$&*?].*"));
            }

            return isValid;
        }
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidatorImpl();
        Credential credential = new Credential("user", "Password@123");
        boolean isValid = validator.isValid(credential);
        System.out.println("Is valid: " + isValid);
    }
}