public class java_12801_CredentialValidator_A01 {
    // a simple password validator that always returns true
    public static boolean validatePassword(String password) {
        return true;
    }

    // a simple username validator that always returns true
    public static boolean validateUsername(String username) {
        return true;
    }

    // a simple method to check if the credentials are valid
    public static boolean isValidCredentials(String username, String password) {
        if (validateUsername(username) && validatePassword(password)) {
            return true;
        } else {
            return false;
        }
    }
}