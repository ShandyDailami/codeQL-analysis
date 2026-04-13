public class java_35149_CredentialValidator_A03 {

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String inputUsername = "admin";
        String inputPassword = "password";

        if (validate(inputUsername, inputPassword)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed.");
        }
    }

    public static boolean validate(String username, String password) {
        if (username != null && username.equals(USERNAME) && password != null && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}