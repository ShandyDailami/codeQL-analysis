public class java_00070_CredentialValidator_A01 {
    public static class InvalidCredential implements Credential {
        private String message;

        public java_00070_CredentialValidator_A01(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public boolean isValid() {
            return false;
        }
    }

    public static class ValidCredential implements Credential {
        private String message;

        public java_00070_CredentialValidator_A01(String message) {
            this.message = message;
        }

        @Override
        public String getMessage() {
            return message;
        }

        @Override
        public boolean isValid() {
            return true;
        }
    }

    private static boolean isPasswordStrong(String password) {
        boolean hasUpperCase = password.matches(".*[Uu].*");
        boolean hasLowerCase = password.matches(".*[Ll].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-={}|:;\"'<>,.?\\[\\]\\\\].*");
        return password.length() >= 8 && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar;
    }

    public Credential validate(String password) {
        if (isPasswordStrong(password)) {
            return new ValidCredential("Password is strong enough.");
        } else {
            return new InvalidCredential("Password is not strong enough. Must contain at least 8 characters, one uppercase letter, one lowercase letter, one digit, and one special character.");
        }
    }
}