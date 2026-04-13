public class java_30810_CredentialValidator_A08 {
    // A static array of users.
    private static String[] users = {"user1", "user2", "user3"};
    private static String[] passwords = {"password1", "password2", "password3"};

    // Method to validate the credentials.
    public static boolean validate(String username, String password) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(username) && passwords[i].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // You can use this to test your own credentials.
        if (validate("user1", "password1")) {
            System.out.println("Access granted");
        } else {
            System.out.println("Access denied");
        }
    }
}