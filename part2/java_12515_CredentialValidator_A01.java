public class java_12515_CredentialValidator_A01 {

    private String expectedUsername;
    private String expectedPassword;

    public java_12515_CredentialValidator_A01(String expectedUsername, String expectedPassword) {
        this.expectedUsername = expectedUsername;
        this.expectedPassword = expectedPassword;
    }

    public boolean isValid(String username, String password) {
        if (username == null || password == null) {
            return false;
        }

        return username.equals(expectedUsername) && password.equals(expectedPassword);
    }
}