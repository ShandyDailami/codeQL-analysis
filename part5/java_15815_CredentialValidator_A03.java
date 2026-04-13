public class java_15815_CredentialValidator_A03 {

    public static boolean validateCredentials(String username, String password) {
        // Here, we're just checking if the username and password are not empty
        if (username == null || password == null) {
            return false;
        }

        // For the sake of simplicity, we're just checking if the username contains a certain sequence of characters
        if (username.contains("password")) {
            return false;
        }

        return true;
    }
}