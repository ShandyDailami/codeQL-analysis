public class java_41633_CredentialValidator_A08 {

    // hard-coded set of valid credentials
    private static final String VALID_USERNAME = "admin";
    private static final String VALID_PASSWORD = "password";

    public boolean validate(String username, String password) {
        // if the provided credentials match the hard-coded credentials, return true
        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        }

        // if the provided credentials do not match the hard-coded credentials, return false
        return false;
    }

}