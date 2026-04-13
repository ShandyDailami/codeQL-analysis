public class java_31187_CredentialValidator_A08 {
    private static final String CORRECT_USERNAME = "admin";
    private static final String CORRECT_PASSWORD = "password";

    public static boolean validateCredentials(String username, String password) {
        if (username.equals(CORRECT_USERNAME) && password.equals(CORRECT_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String inputUsername = "admin"; // replace with actual input
        String inputPassword = "password"; // replace with actual input

        if (validateCredentials(inputUsername, inputPassword)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}