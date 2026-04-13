public class java_29661_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        if (username != null && username.equals(USERNAME) && password != null && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(validateCredentials("admin", "password")); // prints true
        System.out.println(validateCredentials("wrongUser", "password")); // prints false
        System.out.println(validateCredentials("admin", "wrongPassword")); // prints false
    }
}