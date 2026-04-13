public class java_41003_CredentialValidator_A07 {

    private static final String VALID_USERNAME = "validUser";
    private static final String VALID_PASSWORD = "validPass";

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        return username.equals(VALID_USERNAME) && password.equals(VALID_PASSWORD);
    }

}