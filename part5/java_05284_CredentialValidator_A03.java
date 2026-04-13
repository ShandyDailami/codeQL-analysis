public class java_05284_CredentialValidator_A03 {
    private static final String USERNAME_CONTAINER = "admin";

    public static boolean isValid(String username) {
        if (username.contains(USERNAME_CONTAINER)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String user1 = "admin";
        String user2 = "administrator";
        String user3 = "normalUser";

        System.out.println(user1 + " is valid: " + isValid(user1));
        System.out.println(user2 + " is valid: " + isValid(user2));
        System.out.println(user3 + " is valid: " + isValid(user3));
    }
}