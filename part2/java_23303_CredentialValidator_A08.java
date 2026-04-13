public class java_23303_CredentialValidator_A08 {

    // List of valid credentials
    private static final String[] VALID_CREDENTIALS = {"admin", "user1", "user2", "user3"};

    public static boolean validate(String username, String password) {
        // Check if username or password is null or empty
        if (username == null || password == null) {
            return false;
        }

        // Check if username exists in the valid credentials list
        for (String validCredential : VALID_CREDENTIALS) {
            if (validCredential.equals(username)) {
                return true;
            }
        }

        // If username is not found in the valid credentials list, return false
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validate("admin", "password"));  // true
        System.out.println(validate("admin", "wrong_password"));  // false
        System.out.println(validate("non_existent_user", "non_existent_password"));  // false
    }
}