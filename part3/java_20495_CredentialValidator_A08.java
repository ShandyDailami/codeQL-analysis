public class java_20495_CredentialValidator_A08 {

    // Hardcoded credentials.
    private static String correctUsername = "admin";
    private static String correctPassword = "password";

    // A Credential object contains username and password.
    public static class Credential {
        String username;
        String password;

        public java_20495_CredentialValidator_A08(String username, String password) {
            this.username = username;
            this.password = password;
        }

        // Getters
        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

    // This method will validate the credential.
    public static boolean validateCredential(Credential credential) {
        if (credential.getUsername().equals(correctUsername)
                && credential.getPassword().equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }

    // This is the main method.
    public static void main(String[] args) {
        Credential credential = new Credential("admin", "password");
        if (validateCredential(credential)) {
            System.out.println("Credentials are correct.");
        } else {
            System.out.println("Credentials are incorrect.");
        }
    }
}