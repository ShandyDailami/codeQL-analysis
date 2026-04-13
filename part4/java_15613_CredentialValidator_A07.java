public class java_15613_CredentialValidator_A07 {

    // Define the hard-coded set of valid usernames and passwords
    private static final String[] VALID_USERNAMES = {"user1", "user2", "user3"};
    private static final String[] VALID_PASSWORDS = {"password1", "password2", "password3"};

    public static boolean validate(String username, String password) {
        // Check if the provided username is in the set of valid usernames
        for (String validUsername : VALID_USERNAMES) {
            if (validUsername.equals(username)) {
                // If the username is valid, check if the provided password is in the set of valid passwords
                for (String validPassword : VALID_PASSWORDS) {
                    if (validPassword.equals(password)) {
                        // If the password is valid, return true
                        return true;
                    }
                }
            }
        }
        // If none of the usernames and passwords match, return false
        return false;
    }
}