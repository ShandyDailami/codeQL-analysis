public class java_10593_CredentialValidator_A08 {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static boolean validate(String username, String password) {
        if (username != null && username.equals(USERNAME) && password != null && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String inputUsername = "admin";
        String inputPassword = "password";

        if (validate(inputUsername, inputPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}