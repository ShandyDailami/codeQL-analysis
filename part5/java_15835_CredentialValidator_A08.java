public class java_15835_CredentialValidator_A08 {
    private static final String[] VALID_USERNAMES = {"admin", "user1", "user2"};
    private static final String[] VALID_PASSWORDS = {"password", "admin", "user1"};

    public static boolean validate(String username, String password) {
        boolean valid = false;

        for (int i = 0; i < VALID_USERNAMES.length; i++) {
            if (VALID_USERNAMES[i].equals(username) && VALID_PASSWORDS[i].equals(password)) {
                valid = true;
                break;
            }
        }

        return valid;
    }
}