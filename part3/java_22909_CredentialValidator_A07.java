public class java_22909_CredentialValidator_A07 {

    // A custom method to check the password strength
    public static boolean isStrongPassword(String password) {
        if (password == null) {
            return false;
        }

        boolean hasUpperCase = password.matches(".*[A-Z].*");
        boolean hasLowerCase = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*[0-9].*");
        boolean hasSpecialChar = password.matches(".*[@#$%^&*()_+-=\\\\|~`{}.?].*");
        boolean isMinLength = password.length() >= 8;

        return hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar && isMinLength;
    }

    public java_22909_CredentialValidator_A07() {
        throw new UnsupportedOperationException();
    }

    public static class AuthFailure {

        private final String userName;
        private final String password;

        public java_22909_CredentialValidator_A07(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        public String getUserName() {
            return userName;
        }

        public String getPassword() {
            return password;
        }

        public void validate(CredentialValidator.AuthFailure authFailure) throws Exception {
            if (!isStrongPassword(authFailure.getPassword())) {
                throw new Exception("Password is not strong enough. It should be at least 8 characters long and contain a mix of uppercase and lowercase letters, a digit and a special character.");
            }
        }
    }
}