public class java_30529_CredentialValidator_A01 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPassword";

    public boolean validate(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD)) {
            return true;
        } else {
            return false;
        }
    }
}