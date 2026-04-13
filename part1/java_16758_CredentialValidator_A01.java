public class java_16758_CredentialValidator_A01 {

    // A simple credential validator. This validator only verifies the password length.
    public static boolean isValidPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        // The rest of the validation logic is left out for brevity.

        return true;
    }

    // A simple credential validator that validates the username.
    public static boolean isValidUsername(String username) {
        if (username == null || username.length() == 0) {
            return false;
        }

        // The rest of the validation logic is left out for brevity.

        return true;
    }

    // A simple credential validator that validates the password and username.
    public static boolean isValidCredentials(String username, String password) {
        return isValidUsername(username) && isValidPassword(password);
    }

}