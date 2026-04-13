public class java_14862_CredentialValidator_A08 {
    // A simple check to ensure a password meets the complexity requirements
    public static boolean isPasswordComplex(String password) {
        // Require a minimum of 8 characters, one uppercase letter, one lowercase letter, and one special character
        if (password.length() < 8) {
            return false;
        }
        boolean upperCase = false, lowerCase = false, specialChar = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) upperCase = true;
            if (Character.isLowerCase(ch)) lowerCase = true;
            if (!Character.isLetter(ch)) specialChar = true;
            if (upperCase && lowerCase && specialChar) return true;
        }
        return false;
    }

    // A simple check to ensure a username is in the correct format
    public static boolean isUsernameValid(String username) {
        // For simplicity, we only check the format
        if (username.matches("^[a-zA-Z0-9._%+-]+$")) return true;
        return false;
    }

    // A simple class to store a credential and ensure they are valid
    public static class Credential {
        private String username;
        private String password;

        public java_14862_CredentialValidator_A08(String username, String password) {
            if (!isUsernameValid(username)) {
                throw new IllegalArgumentException("Invalid username");
            }
            if (!isPasswordComplex(password)) {
                throw new IllegalArgumentException("Invalid password");
            }
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
}