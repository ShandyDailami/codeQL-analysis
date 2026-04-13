public class java_31049_CredentialValidator_A08 {

    private static final String USERNAME = "testUser";
    private static final String PASSWORD = "testPassword";

    public static boolean validate(String username, String password) {
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String testUsername = "testUser";
        String testPassword = "wrongPassword";

        if (validate(testUsername, testPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}