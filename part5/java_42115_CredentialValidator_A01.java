public class java_42115_CredentialValidator_A01 {

    private static final String[] ALLOWED_USERNAMES = {"user1", "user2", "user3"};
    private static final String[] ALLOWED_PASSWORDS = {"password1", "password2", "password3"};

    public static boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        for (String allowedUsername : ALLOWED_USERNAMES) {
            if (allowedUsername.equals(username)) {
                for (String allowedPassword : ALLOWED_PASSWORDS) {
                    if (allowedPassword.equals(password)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("user1", "password1")); // Should print true
        System.out.println(isValid("user4", "password4")); // Should print false
        System.out.println(isValid("user2", "wrongpassword")); // Should print false
    }
}