public class java_38001_CredentialValidator_A08 {

    private static final String USERNAME = "test";
    private static final String PASSWORD = "test";

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            throw new IllegalArgumentException("Username and password must not be null");
        }

        if (username.equals(USERNAME) && password.equals(PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}