public class java_25556_CredentialValidator_A08 {

    public static class CredentialValidator {

        // A method to check if the given password is strong enough
        public boolean isPasswordStrong(String password) {
            // The password should not be null and should be at least 8 characters long
            if (password == null || password.length() < 8) {
                return false;
            }

            // The password should contain at least one uppercase letter, one lowercase letter, one digit and one special character
            if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$")) {
                return false;
            }

            // The password should not be too similar to system credentials
            if (password.contains("password") || password.contains("admin") || password.contains("super")) {
                return false;
            }

            return true;
        }

        // A method to check if the given username is valid
        public boolean isUsernameValid(String username) {
            // The username should not be null and should be at least 4 characters long
            if (username == null || username.length() < 4) {
                return false;
            }

            // The username should not be too similar to system credentials
            if (username.contains("admin") || username.contains("super")) {
                return false;
           
            }

            return true;
        }
    }
}