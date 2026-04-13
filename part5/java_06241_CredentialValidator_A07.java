public class java_06241_CredentialValidator_A07 {
    // Static array of user credentials
    private static final String[][] USERS = {
        { "user1", "password1" },
        { "user2", "password2" },
        { "user3", "password3" }
    };

    // Method to validate credentials
    public static boolean validate(String username, String password) {
        for (String[] user : USERS) {
            if (user[0].equals(username) && user[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Test the validator
    public static void main(String[] args) {
        System.out.println(validate("user1", "password1")); // true
        System.out.println(validate("user4", "password4")); // false
    }
}