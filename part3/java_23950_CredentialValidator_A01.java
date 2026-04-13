public class java_23950_CredentialValidator_A01 {
    // predefined list of allowed usernames and passwords
    private static final String[][] allowedUsers = {
        {"user1", "password1"},
        {"user2", "password2"},
        {"user3", "password3"},
        // add more users as needed
    };

    // validate a username and password
    public static boolean validate(String username, String password) {
        // check if the username and password match any in the allowed list
        for (String[] user : allowedUsers) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // main method for testing
    public static void main(String[] args) {
        // try to login with known good credentials
        if (validate("user1", "password1")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}