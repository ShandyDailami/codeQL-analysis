public class java_15683_CredentialValidator_A03 {

    private static final String ALLOWED_USERNAME = "admin";
    private static final String ALLOWED_PASSWORD = "password";

    public static void main(String[] args) {
        String inputUsername = "admin";
        String inputPassword = "password";

        if (validateCredentials(inputUsername, inputPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }

    public static boolean validateCredentials(String username, String password) {
        if (username.equals(ALLOWED_USERNAME) && password.equals(ALLOWED_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}