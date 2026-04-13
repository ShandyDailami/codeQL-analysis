public class java_14160_CredentialValidator_A08 {

    // This is a static array of allowed users.
    // In a real-world application, it would come from a secure database or API.
    private static final String[] ALLOWED_USERS = {"user1", "user2", "user3"};

    // This is a static array of allowed passwords.
    // In a real-world application, it would come from a secure database or API.
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    // This method validates the provided username and password.
    // It returns true if the username and password are in the allowed list, false otherwise.
    public boolean validate(String username, String password) {
        boolean isValidUser = false;
        boolean isValidPassword = false;

        // Loop through the allowed users and passwords.
        for (String allowedUser : ALLOWED_USERS) {
            if (allowedUser.equals(username)) {
                isValidUser = true;
                break;
            }
        }

        for (String allowedPassword : ALLOWED_PASSWORDS) {
            if (allowedPassword.equals(password)) {
                isValidPassword = true;
                break;
            }
        }

        // If the username and password are in the allowed list, return true. Otherwise, return false.
        return isValidUser && isValidPassword;
    }
}