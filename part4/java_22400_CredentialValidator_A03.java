public class java_22400_CredentialValidator_A03 {

    // Sample valid users
    private static final String[] VALID_USERS = {"user1", "user2", "user3"};

    // Sample valid passwords
    private static final String[] VALID_PASSWORDS = {"pass1", "pass2", "pass3"};

    public static boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        // Assume we have a method getValidUsers() that returns the list of valid users
        // and getValidPasswords() that returns the list of valid passwords
        // Note: these methods are not implemented in this example

        for (String validUser : VALID_USERS) {
            if (username.equals(validUser)) {
                for (String validPassword : VALID_PASSWORDS) {
                    if (password.equals(validPassword)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String user = "user1";
        String password = "pass1";
        if (validate(user, password)) {
            System.out.println("Access granted for user: " + user);
        } else {
            System.out.println("Access denied for user: " + user);
        }
    }
}