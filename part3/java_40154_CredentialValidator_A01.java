public class java_40154_CredentialValidator_A01 {

    // Hard-coded credentials for demonstration purposes
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    public boolean validate(String username, String password) {
        // Check if the provided username and password match the hard-coded credentials
        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            System.out.println("Access granted!");
            return true;
        } else {
            System.out.println("Access denied!");
            return false;
        }
    }

}